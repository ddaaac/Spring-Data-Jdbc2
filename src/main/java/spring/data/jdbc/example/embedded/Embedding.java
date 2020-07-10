package spring.data.jdbc.example.embedded;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Embedding {
    private final String name1x;

    private final String name2x;
}
