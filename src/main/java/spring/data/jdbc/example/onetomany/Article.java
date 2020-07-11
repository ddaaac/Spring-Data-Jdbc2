package spring.data.jdbc.example.onetomany;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Article {
    @Id
    private Long id;

    private String author;

    private String contents;

    @Embedded.Empty
    @Builder.Default
    private Comments comments = Comments.empty();

    public void addComment(Comment comment) {
        comments.addComment(comment);
    }
}
