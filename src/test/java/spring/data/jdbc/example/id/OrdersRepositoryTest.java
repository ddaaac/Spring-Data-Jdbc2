package spring.data.jdbc.example.id;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrdersRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void orderIdUUID() {
        Orders orders = orderRepository.save(new Orders(null, "order_title"));

        assertThat(orders.getId()).isNotNull();
    }
}
