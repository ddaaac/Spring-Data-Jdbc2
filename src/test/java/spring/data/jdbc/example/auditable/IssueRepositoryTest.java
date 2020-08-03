package spring.data.jdbc.example.auditable;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootTest
class IssueRepositoryTest {
    @Autowired
    private IssueRepository issueRepository;

    @Test
    void auditFinalField() {
        final Issue issue = issueRepository.save(
            Issue.builder().title("이슈").memberId(AggregateReference.to(1L)).build());

        assertThat(issue.getCreatedAt()).isNotNull();
        assertThat(issue.getUpdatedAt()).isNotNull();
    }

    @Test
    void witherAccessibility() {
        final Issue issue = issueRepository.save(
            Issue.builder().title("이슈").memberId(AggregateReference.to(1L)).build());

        final Issue persisted = issueRepository.findById(issue.getId()).get();

        assertThat(persisted.getCreatedAt()).isEqualTo(issue.getCreatedAt());
        assertThat(persisted.getUpdatedAt()).isEqualTo(issue.getUpdatedAt());
    }
}
