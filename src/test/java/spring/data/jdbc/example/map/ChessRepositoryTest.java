package spring.data.jdbc.example.map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
public class ChessRepositoryTest {
    @Autowired
    private ChessRepository chessRepository;

    @Test
    void map() {
        Map<String, Piece> boards = new HashMap<>();
        boards.put("a1", new Piece("Rook"));
        boards.put("a2", new Piece("Pawn"));
        boards.put("b1", new Piece("Knight"));
        boards.put("c1", new Piece("Bishop"));

        Chess chess = Chess.builder().boards(boards).build();
        chessRepository.save(chess);
        Chess persistChess = chessRepository.findById(1L).get();

        assertThat(persistChess.getBoards()).isEqualTo(boards);
    }
}

