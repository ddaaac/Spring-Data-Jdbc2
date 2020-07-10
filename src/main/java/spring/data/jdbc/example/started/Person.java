package spring.data.jdbc.example.started;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Person {
    @Id
    private Long personId;

    private final String personName;

    private int age;
}
