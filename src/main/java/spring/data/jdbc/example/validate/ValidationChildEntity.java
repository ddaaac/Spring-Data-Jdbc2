package spring.data.jdbc.example.validate;

import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ValidationChildEntity {

    @Email
    private final String email;
}
