package spring.data.jdbc.example.aggregate;

import java.util.List;

import org.springframework.data.jdbc.core.mapping.AggregateReference;

public interface FavoriteRepositoryCustom {
    List<Favorite> findBySourceIdOrTargetId(AggregateReference<Favorite, Long> subwayId);
}
