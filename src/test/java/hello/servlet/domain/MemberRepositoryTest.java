package hello.servlet.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void clear() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("member", 20);

        // when
        Member save = memberRepository.save(member);

        // then
        assertThat(member).isEqualTo(save);
    }

    @Test
    void findAllTest() {
        // given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);

        memberRepository.save(member1);
        memberRepository.save(member2);

        // when
        List<Member> result = memberRepository.findAll();

        // then
        assertThat(result).hasSize(2);
        assertThat(result).contains(member1, member2);
    }
}
