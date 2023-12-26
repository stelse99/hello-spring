package hello.core.service;

import hello.core.domain.Member;

public interface DiscountPolicy {
    /**
     * 할인대상금액
     */
    int discount(Member member, int price);
}
