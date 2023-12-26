package hello.core.repository;

import hello.core.domain.Grade;
import hello.core.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    @DisplayName("저장 테스트")
    public void save(){
        Member member = new Member(0L, "Spring", Grade.VIP);

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //System.out.printf("result = " + (result == member));
        Assertions.assertEquals( member , result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member(0L, "Spring1", Grade.VIP);
        repository.save(member1);

        Member member2 = new Member(0L, "Spring2", Grade.VIP);
        repository.save(member2);

        Member result = repository.findByName("Spring1").orElseThrow();

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member(0L, "Spring1", Grade.VIP);
        repository.save(member1);

        Member member2 = new Member(0L, "Spring2", Grade.VIP);
        member2.setName("spring2");
        repository.save(member2);

        Member member3 = new Member(0L, "Spring3", Grade.VIP);
        member3.setName("spring3");
        repository.save(member3);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(3);
    }
}
