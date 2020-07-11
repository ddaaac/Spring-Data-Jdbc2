package spring.data.jdbc.example.time;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TimeEntityBaseRepositoryTest {
    @Autowired
    private TimeEntityBaseRepository timeEntityBaseRepository;

    @DisplayName("Aggregate Root가 아닌 엔티티는 @CreatedDate, @LastModifiedDate가 적용되지 않음")
    @Test
    void aggregateChildDoesntHaveDate() {
        TimeChild child = TimeChild.builder().name("새로운 자식").build();

        TimeEntityBase parent = TimeEntityBase.builder()
            .children(new ArrayList<>())
            .name("새로운 부모")
            .build()
            .addChild(child);

        TimeEntityBase persisted = timeEntityBaseRepository.save(parent);
        TimeChild persistedChild = persisted.getChildren().get(0);

        assertAll(
            () -> assertThat(persisted.getCreatedAt()).isNotNull(),
            () -> assertThat(persistedChild.getCreatedAt()).isNull()
        );
    }
}
