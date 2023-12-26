package hello.core.service;

import hello.core.AppConfig;
import hello.core.domain.Grade;
import hello.core.domain.Member;
import hello.core.domain.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        long memberId = 0L;
        Member member = new Member(memberId, "ssss", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(member.getId(), "ITEMA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}