package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

// 어플리케이션에 대한 상세 설정을 진행
// 의존 관계 주입 DI(Dependency Injection)
// 역할을 세우고 그 안에 구현이 드러 나도록 수정
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(
                memberRepository()
        );
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(), discountPolicy()
        );
    }

    public DiscountPolicy discountPolicy() {
        // 고정 할인 -> 비율 할인
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
