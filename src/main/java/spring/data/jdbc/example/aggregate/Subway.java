package spring.data.jdbc.example.aggregate;

import java.time.Instant;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.With;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
@EqualsAndHashCode(of = "id")
public class Subway {
    @Id
    @With(value = AccessLevel.PACKAGE)
    private final long id;

    @NotBlank
    private final String name;

    @Builder.Default
    private final Instant createdAt = Instant.now();

    @Builder.Default
    private final Instant updatedAt = Instant.now();

    public Subway update(String name) {
        return Subway.builder()
            .id(id)
            .name(name)
            .createdAt(createdAt)
            .updatedAt(Instant.now())
            .build();
    }
}
