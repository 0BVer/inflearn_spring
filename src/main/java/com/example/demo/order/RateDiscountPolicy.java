package com.example.demo.order;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
