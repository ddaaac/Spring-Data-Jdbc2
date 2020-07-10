package spring.data.jdbc.example.embedded;

import org.springframework.data.repository.CrudRepository;

public interface EmbeddedEntityRepository extends CrudRepository<EmbeddedEntity, Long> {
}
