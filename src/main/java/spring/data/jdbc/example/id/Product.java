package spring.data.jdbc.example.id;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Product {
    @Id
    private final long id;

    private final String name;

    @Version
    private long version;
}
