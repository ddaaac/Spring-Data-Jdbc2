package spring.data.jdbc.example.aggregate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import spring.data.jdbc.example.config.JdbcConfig;

@DataJdbcTest
@Import(JdbcConfig.class)
class FavoriteTest {
    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private SubwayRepository subwayRepository;

    private List<Subway> subways;

    @BeforeEach
    void setUp() {
        Subway samsong = Subway.builder().name("삼송").build();
        Subway jichuk = Subway.builder().name("지축").build();
        subways = subwayRepository.saveAll(Arrays.asList(samsong, jichuk));
    }

    @Test
    void customFindMethodByAggregateReference() {
        Subway samsong = subways.get(0);
        Subway jichuk = subways.get(1);

        Favorite favorite = Favorite.builder()
            .sourceId(AggregateReference.to(samsong.getId()))
            .targetId(AggregateReference.to(jichuk.getId()))
            .name("내 즐겨찾기")
            .build();

        Favorite persisted = favoriteRepository.save(favorite);
        List<Favorite> favorites = favoriteRepository.findBySourceIdOrTargetId(
            AggregateReference.to(samsong.getId()));

        assertAll(
            () -> assertThat(persisted.getSourceId().getId()).isEqualTo(samsong.getId()),
            () -> assertThat(favorites).isNotNull()
        );
    }

    @Test
    void createdAndUpdatedDate() {
        Subway samsong = subways.get(0);
        Subway jichuk = subways.get(1);

        Favorite favorite = Favorite.builder()
            .sourceId(AggregateReference.to(samsong.getId()))
            .targetId(AggregateReference.to(jichuk.getId()))
            .name("내 즐겨찾기")
            .build();

        Favorite firstPersisted = favoriteRepository.save(favorite);
        Favorite updated = firstPersisted.withName("바뀐 즐겨찾기");
        Favorite persisted = favoriteRepository.save(updated);

        assertAll(
            () -> assertThat(firstPersisted.getCreatedAt()).isNotNull(),
            () -> assertThat(firstPersisted.getUpdatedAt()).isNotNull(),
            () -> assertThat(persisted.getCreatedAt()).isBefore(persisted.getUpdatedAt())
        );
    }
}
