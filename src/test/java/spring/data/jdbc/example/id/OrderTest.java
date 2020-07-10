package spring.data.jdbc.example.id;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;

import spring.data.jdbc.example.config.JdbcConfig;

@DataJdbcTest
@Import(JdbcConfig.class)
class OrderTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void orderIdUUID() {
        Order order = orderRepository.save(new Order(null, "order_title"));

        assertThat(order.getId()).isNotNull();
    }
}
