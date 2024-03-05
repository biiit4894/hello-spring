package com.estsoft.hellospring.controller;
import com.estsoft.hellospring.domain.Member;
import com.estsoft.hellospring.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    @GetMapping("/members")
    @ResponseBody   // @RestController
    public List<MemberDTO> getAllMembers() {
        return memberService.getAllMembers();
        // json: [{"id": "", "name": "", "phone": ""}]
    }

}
