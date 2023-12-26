package hello.core.service;

import hello.core.domain.Grade;
import hello.core.domain.Member;
import org.springframework.stereotype.Service;

@Service
public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }
}
