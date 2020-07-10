package spring.data.jdbc.example.id;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Member {
    @Id
    private final long id;

    private final String name;
}
