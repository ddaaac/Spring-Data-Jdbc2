package spring.data.jdbc.example.embedded;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmbeddedEntity {
    @Id
    private final Long id;

    private final String name;

    @Embedded(prefix = "CHILD1_", onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private final Embedding child1;

    @Embedded(prefix = "CHILD2_", onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private final Embedding child2;
}
