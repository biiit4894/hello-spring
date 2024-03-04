package com.estsoft.hellospring.service;

import com.estsoft.hellospring.controller.MemberDTO;
import com.estsoft.hellospring.domain.Member;
import com.estsoft.hellospring.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberDTO> getAllMembers() {
        List<Member> memberList = memberRepository.findAll();
        System.out.println("memberList = " + memberList);
        List<MemberDTO> resultList = memberList.stream().map(member -> new MemberDTO(member.getId(), member.getName())).toList();
        return resultList;
        // select *  from member

    }
}
