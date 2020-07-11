package spring.data.jdbc.example.validate;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ValidationEmbeddedEntity {
    @NotNull
    private final String embeddedName;
}
