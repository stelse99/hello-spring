package hello.core.service;

import hello.core.AppConfig;
import hello.core.domain.Grade;
import hello.core.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member = new Member(0L, "Spring", Grade.VIP);
        //when
        memberService.join(member);
        Member member1 = memberService.findMember(member.getId()).get();
        //then
        assertThat(member).isEqualTo(member1);
    }

    @Test
    void findByAll() {
    }

    @Test
    void findOne() {
    }
}