package com.example.demo.member;

import com.example.demo.AppConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService  memberService;

    @BeforeEach //각 테스트 실행 전에 실행
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given 이것이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 이 상황에서
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 이렇게 될것이다.
        Assertions.assertSame(member, findMember);
    }
}
