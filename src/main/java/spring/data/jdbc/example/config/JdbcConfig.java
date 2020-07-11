package spring.data.jdbc.example.config;

import java.util.Arrays;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.relational.core.mapping.event.BeforeSaveCallback;

import lombok.AllArgsConstructor;
import spring.data.jdbc.example.converter.EncryptString;
import spring.data.jdbc.example.converter.Encryptor;
import spring.data.jdbc.example.converter.SimpleEncryptor;
import spring.data.jdbc.example.id.Orders;
import spring.data.jdbc.example.id.User;

@Configuration
@EnableJdbcAuditing
public class JdbcConfig extends AbstractJdbcConfiguration {
    @Bean
    @Order
    BeforeSaveCallback<?> validateBeforeSave(Validator validator) {
        return ((aggregate, aggregateChange) -> {
            Set<ConstraintViolation<Object>> violations = validator.validate(aggregate);
            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
            return aggregate;
        });
    }

    @Override
    public JdbcCustomConversions jdbcCustomConversions() {
        Encryptor encryptor = new SimpleEncryptor();

        return new JdbcCustomConversions(Arrays.asList(
            new EncryptWritingPassword(encryptor),
            new DecryptWritingPassword(encryptor)
        ));
    }

    @WritingConverter
    @AllArgsConstructor
    static class EncryptWritingPassword implements Converter<EncryptString, byte[]> {
        private final Encryptor encryptor;

        @Override
        public byte[] convert(final EncryptString source) {
            return encryptor.encrypt(source.getValue());
        }
    }

    @ReadingConverter
    @AllArgsConstructor
    static class DecryptWritingPassword implements Converter<byte[], EncryptString> {
        private final Encryptor encryptor;

        @Override
        public EncryptString convert(final byte[] source) {
            return new EncryptString(encryptor.decrypt(source));
        }
    }

    @Bean
    User.BeforeSaveUser beforeSaveUser() {
        return new User.BeforeSaveUser();
    }

    @Bean
    Orders.BeforeSaveOrderCallback beforeSaveOrderCallback() {
        return new Orders.BeforeSaveOrderCallback();
    }
}
