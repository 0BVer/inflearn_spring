package com.example.demo;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;
import com.example.demo.member.MemoryMemberRepository;
import com.example.demo.order.OrderService;
import com.example.demo.order.OrderServiceImpl;
import com.example.demo.discount.RateDiscountPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public MemberRepository memberRepository() { //여기만 바꾸면 다른 구현체로 바꿀 수 있다.
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() { //여기만 바꾸면 다른 구현체로 바꿀 수 있다.
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy(); //이렇게 바꾸면 할인 정책이 바뀐다.
    }
}
