package spring.data.jdbc.example.aggregate;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SubwayRepository extends CrudRepository<Subway, Long> {
    <S extends Subway> List<S> saveAll(Iterable<S> entities);
}
