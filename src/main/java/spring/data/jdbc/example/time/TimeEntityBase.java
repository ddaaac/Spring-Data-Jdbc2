package spring.data.jdbc.example.time;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.With;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode(of = "id", callSuper = false)
@Getter
public class TimeEntityBase extends BaseEntity {
    @Id
    private final Long id;

    @NotBlank
    private final String name;

    @MappedCollection(idColumn = "PARENT_ID", keyColumn = "PARENT_KEY")
    @NotNull
    @With(AccessLevel.PRIVATE)
    private final List<TimeChild> children;

    @PersistenceConstructor
    private TimeEntityBase(Long id, String name, List<TimeChild> children, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.children = children;
    }

    public TimeEntityBase addChild(TimeChild child) {
        List<TimeChild> newChildren = new ArrayList<>(children);
        newChildren.add(child);
        return withChildren(newChildren);
    }
}
