package spring.data.jdbc.example.auditable;

import org.springframework.data.repository.CrudRepository;

public interface IssueRepository extends CrudRepository<Issue, Long> {
}
