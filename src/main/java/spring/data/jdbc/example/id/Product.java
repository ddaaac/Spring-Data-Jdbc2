package spring.data.jdbc.example.id;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

public class Product {
    @Id
    private final long id;
    private final String name;
    @Version
    private long version;

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }
}
