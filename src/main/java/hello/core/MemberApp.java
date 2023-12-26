package hello.core;

import hello.core.domain.Grade;
import hello.core.domain.Member;
import hello.core.service.MemberService;

import java.util.Optional;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService =  appConfig.memberService();
        Member member = new Member(0L, "kkk", Grade.VIP);
        memberService.join(member);

        Optional<Member> member1 = memberService.findMember(member.getId());
        System.out.println("member.getName() = " + member.getName());
        System.out.println("member1.orElseThrow().getName() = " + member1.orElseThrow().getName());
    }
}
