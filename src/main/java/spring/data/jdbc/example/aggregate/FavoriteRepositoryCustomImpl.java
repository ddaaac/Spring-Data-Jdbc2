package spring.data.jdbc.example.aggregate;

import java.util.List;

import org.springframework.data.jdbc.core.convert.EntityRowMapper;
import org.springframework.data.jdbc.core.convert.JdbcConverter;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.RelationalMappingContext;
import org.springframework.data.relational.core.mapping.RelationalPersistentEntity;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class FavoriteRepositoryCustomImpl implements FavoriteRepositoryCustom {
    private final NamedParameterJdbcOperations jdbcOperations;
    private final EntityRowMapper<Favorite> rowMapper;

    @SuppressWarnings("unchecked")
    public FavoriteRepositoryCustomImpl(
        NamedParameterJdbcOperations jdbcOperations,
        RelationalMappingContext mappingContext,
        JdbcConverter jdbcConverter) {

        this.jdbcOperations = jdbcOperations;
        this.rowMapper = new EntityRowMapper<>(
            (RelationalPersistentEntity<Favorite>)
                mappingContext.getRequiredPersistentEntity(Favorite.class),
            jdbcConverter);
    }

    @Override
    public List<Favorite> findBySourceIdOrTargetId(AggregateReference<Favorite, Long> subwayId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("sourceId", subwayId.getId())
            .addValue("targetId", subwayId.getId());

        return jdbcOperations.query(
            selectFavoriteBySourceIdOrTargetId(), parameterSource, rowMapper);
    }

    private static String selectFavoriteBySourceIdOrTargetId() {
        return new StringBuilder()
            .append("SELECT FAVORITE.ID AS ID")
            .append(", FAVORITE.SOURCE_ID AS SOURCE_ID, FAVORITE.TARGET_ID AS TARGET_ID")
            .append(" FROM FAVORITE")
            .append(" WHERE SOURCE_ID = :sourceId OR TARGET_ID = :targetId")
            .toString();
    }
}
