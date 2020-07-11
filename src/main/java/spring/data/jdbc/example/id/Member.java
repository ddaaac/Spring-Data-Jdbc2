package spring.data.jdbc.example.id;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Auditable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import spring.data.jdbc.example.converter.EncryptString;

@AllArgsConstructor
@Getter
public class Member {
    @Id
    private final long id;

    private final String name;

    private final EncryptString password;
}
