package spring.data.jdbc.example.onetomany;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
public class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;

    @Test
    void oneToMany() {
        Article article = Article.builder().author("효혁").contents("글 내용").build();
        article.addComment(new Comment("글 잘봤어요!"));
        article.addComment(new Comment("좋은 글이네요:)"));

        articleRepository.save(article);
        Article persistArticle = articleRepository.findById(1L).get();
        assertThat(persistArticle.getComments().getComments()).hasSize(2);
    }
}
