package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 추상화와 구체화에 모두 의존하고 있기 때문에 DIP를 위배하고 있다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
