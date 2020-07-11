package spring.data.jdbc.example.validate;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ValidationEntity {
    @Id
    private final Long id;

    @Builder.Default
    @Size(min = 3)
    private final String longThanThree = "longEnoughString";

    @Builder.Default
    @NotBlank
    private final String notBlank = "not blanked";

    @Builder.Default
    @PastOrPresent
    private final LocalDateTime past = LocalDateTime.now();

    @Builder.Default
    @PositiveOrZero
    private final int positive = 0;

    @Builder.Default
    @Valid
    @Embedded.Empty
    private final ValidationEmbeddedEntity embedded = new ValidationEmbeddedEntity("embeddedName");

    @Builder.Default
    @Valid
    private final ValidationChildEntity child = new ValidationChildEntity("somevalid@valid.com");
}
