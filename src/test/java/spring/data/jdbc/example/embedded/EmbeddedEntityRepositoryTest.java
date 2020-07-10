package spring.data.jdbc.example.embedded;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class EmbeddedEntityRepositoryTest {
    @Autowired
    private EmbeddedEntityRepository embeddedParentRepository;

    @Test
    void duplicateEmbeddedColumnName() {
        EmbeddedEntity entity = EmbeddedEntity.builder()
            .name("부모")
            .child1(Embedding.builder().name1x("child1_name1").name2x("child1_name2").build())
            .child2(Embedding.builder().name1x("child2_name1").name2x("child2_name2").build())
            .build();

        EmbeddedEntity persisted = embeddedParentRepository.save(entity);

        assertThat(persisted.getId()).isNotNull();
    }
}
