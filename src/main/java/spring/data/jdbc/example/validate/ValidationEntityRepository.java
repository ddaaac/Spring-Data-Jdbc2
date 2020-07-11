package spring.data.jdbc.example.validate;

import org.springframework.data.repository.CrudRepository;

public interface ValidationEntityRepository extends CrudRepository<ValidationEntity, Long> {
}
