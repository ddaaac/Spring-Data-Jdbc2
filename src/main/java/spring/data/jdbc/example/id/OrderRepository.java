package spring.data.jdbc.example.id;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, UUID> {
}
