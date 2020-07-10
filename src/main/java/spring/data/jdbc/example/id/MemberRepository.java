package spring.data.jdbc.example.id;

import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long>, WithInsert<Member> {
}
