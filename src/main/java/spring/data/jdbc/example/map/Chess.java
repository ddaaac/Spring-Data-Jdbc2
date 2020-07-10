package spring.data.jdbc.example.map;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Chess {
    @Id
    private Long id;

    @MappedCollection(idColumn = "CHESS_ID", keyColumn = "POSITION")
    private Map<String, Piece> boards;
}
