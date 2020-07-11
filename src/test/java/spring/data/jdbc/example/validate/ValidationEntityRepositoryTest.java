package spring.data.jdbc.example.validate;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ValidationEntityRepositoryTest {
    @Autowired
    private ValidationEntityRepository validationEntityRepository;

    @ParameterizedTest
    @MethodSource("generateInvalidEntity")
    void notValidEntityThrowException(ValidationEntity entity) {
        assertThatThrownBy(() -> validationEntityRepository.save(entity))
            .isInstanceOf(ConstraintViolationException.class);
    }

    static Stream<Arguments> generateInvalidEntity() {
        return Stream.of(
            Arguments.of(ValidationEntity.builder().child(new ValidationChildEntity("invalid.email#form.com")).build()),
            Arguments.of(ValidationEntity.builder().embedded(new ValidationEmbeddedEntity(null)).build()),
            Arguments.of(ValidationEntity.builder().longThanThree("22").build()),
            Arguments.of(ValidationEntity.builder().notBlank("").build()),
            Arguments.of(ValidationEntity.builder().past(LocalDateTime.now().plusDays(1L)).build()),
            Arguments.of(ValidationEntity.builder().positive(-1).build())
        );
    }
}
