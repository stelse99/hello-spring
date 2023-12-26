package hello.core;

import hello.core.domain.Grade;
import hello.core.domain.Member;
import hello.core.domain.Order;
import hello.core.service.MemberService;
import hello.core.service.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 0L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberA.getId(), "ITEMA", 10000);
        System.out.println("order = " + order);

    }
}

