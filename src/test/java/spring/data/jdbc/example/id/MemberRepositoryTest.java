package spring.data.jdbc.example.id;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import spring.data.jdbc.example.converter.EncryptString;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void memberInsert() {
        Member member = memberRepository.insert(new Member(1L, "효혁", new EncryptString("486")));

        assertThat(member.getId()).isEqualTo(1L);
    }

    @Test
    void passwordConvert() {
        Member member = memberRepository.insert(new Member(1L, "효혁", new EncryptString("486")));

        assertThat(member.getPassword().getValue()).isEqualTo("486");
    }
}
