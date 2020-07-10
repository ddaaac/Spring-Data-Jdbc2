package spring.data.jdbc.example.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.relational.core.mapping.MappedCollection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Comments {
    @MappedCollection(keyColumn = "ARTICLE_KEY")
    private List<Comment> comments;

    public static Comments empty() {
        return new Comments(new ArrayList<>());
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
