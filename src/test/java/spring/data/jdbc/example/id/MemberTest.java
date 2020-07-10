package spring.data.jdbc.example.id;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

@DataJdbcTest
class MemberTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void memberInsert() {
        Member member = memberRepository.insert(new Member(1L, "효혁"));

        assertThat(member.getId()).isEqualTo(1L);
    }
}
