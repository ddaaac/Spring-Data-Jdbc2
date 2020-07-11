package spring.data.jdbc.example.aggregate;

import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository
    extends CrudRepository<Favorite, Long>, FavoriteRepositoryCustom {
}
