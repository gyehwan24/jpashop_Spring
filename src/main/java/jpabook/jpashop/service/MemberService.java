package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)  //읽기에는 (readOnly = true)로 해주는 것이 좋다.
@RequiredArgsConstructor  //final 달린 필드만 생성자 생성
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired //인젝션 방식 = 필드 or 세터 or 생성자
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    //회원 가입
    @Transactional
    public Long join(Member member) {
        validateDuplicatedMember(member);  //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    //회원 가입시 예외처리
    private void validateDuplicatedMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    //회원 단건 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);
    }
}
