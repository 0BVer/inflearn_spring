package com.example.demo.order;

import com.example.demo.discount.RateDiscountPolicy;
import com.example.demo.member.Grade;
import com.example.demo.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertEquals(discount, 1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인이 적용되면 안된다.")
    void vip_x(){ //실패하는 테스트
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        assertEquals(discount, 0);
    }
}