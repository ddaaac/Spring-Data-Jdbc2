package spring.data.jdbc.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

import spring.data.jdbc.example.id.Order;
import spring.data.jdbc.example.id.User;

@Configuration
@EnableJdbcAuditing
public class JdbcConfig {
    @Bean
    User.BeforeSaveUser beforeSaveUser() {
        return new User.BeforeSaveUser();
    }

    @Bean
    Order.BeforeSaveOrderCallback beforeSaveOrderCallback() {
        return new Order.BeforeSaveOrderCallback();
    }
}
