package spring.data.jdbc.example.id;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void productInsert() {
        Product product = new Product(100L, "물건");

        Product actual = productRepository.save(product);

        assertAll(
            () -> assertThat(actual.getId()).isEqualTo(100L),
            () -> assertThat(actual.getVersion()).isEqualTo(1L)
        );
    }
}
