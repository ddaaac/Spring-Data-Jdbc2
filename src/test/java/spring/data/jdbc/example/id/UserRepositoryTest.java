package spring.data.jdbc.example.id;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;

import spring.data.jdbc.example.config.JdbcConfig;

@DataJdbcTest
@Import(JdbcConfig.class)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Disabled
    void idAutoGenerate() {
        User user = User.of(null, "효혁");
        User persistedUser = userRepository.save(user);

        assertThat(user.getId()).isNull();
        assertThat(persistedUser.getId()).isNotNull();
    }

    @Test
    void notNullIdInsert() {
        User user = User.newUser(1L, "효혁");
        User persistedUser = userRepository.save(user);

        assertThat(persistedUser.getId()).isEqualTo(1L);
    }
}
