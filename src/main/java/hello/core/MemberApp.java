package hello.core;

import hello.core.domain.Grade;
import hello.core.domain.Member;
import hello.core.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService =  appConfig.memberService();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(0L, "kkk", Grade.VIP);
        memberService.join(member);

        Optional<Member> member1 = memberService.findMember(member.getId());
        System.out.println("member.getName() = " + member.getName());
        System.out.println("member1.orElseThrow().getName() = " + member1.orElseThrow().getName());
    }
}
