package spring.data.jdbc.example.aggregate;

import static org.assertj.core.api.Assertions.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import org.assertj.core.data.TemporalUnitWithinOffset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class SubwayTest {
    @Autowired
    private SubwayRepository subwayRepository;

    @Test
    void createdAndUpdatedDate() {
        Subway jichuk = Subway.builder()
            .name("지축역")
            .build();
        Subway persisted = subwayRepository.save(jichuk);
        Instant firstCreated = persisted.getCreatedAt();
        Instant firstUpdated = persisted.getUpdatedAt();

        Subway samsong = persisted.update("삼송역");
        Subway secondPersisted = subwayRepository.save(samsong);
        Instant secondCreated = secondPersisted.getCreatedAt();
        Instant secondUpdated = secondPersisted.getUpdatedAt();

        assertThat(persisted.getId()).isEqualTo(secondPersisted.getId());
        assertThat(firstCreated).isCloseTo(firstUpdated, new TemporalUnitWithinOffset(5000, ChronoUnit.NANOS));
        assertThat(secondCreated).isNotEqualTo(secondUpdated);
        assertThat(secondCreated).isEqualTo(firstCreated);
        assertThat(secondUpdated).isNotEqualTo(firstUpdated);
    }

    @Test
    void saveAllOverride() {
        Subway jichuk = Subway.builder()
            .name("지축역")
            .build();
        Subway samsong = Subway.builder()
            .name("삼송역")
            .build();
        subwayRepository.saveAll(Arrays.asList(jichuk, samsong));
    }
}
