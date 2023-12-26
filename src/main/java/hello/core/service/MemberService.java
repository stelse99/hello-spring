package hello.core.service;

import hello.core.domain.Member;

import java.util.Optional;

public interface MemberService {
    Long join(Member member);
    Optional<Member> findMember(Long memberId);
}
