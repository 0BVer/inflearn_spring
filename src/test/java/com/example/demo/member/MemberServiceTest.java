package com.example.demo.member;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService  memberService = new MemberServiceImpl();

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
