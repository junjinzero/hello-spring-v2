package hello.hellospringv2.controller;

import hello.hellospringv2.domain.Member;
import hello.hellospringv2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    // new 로 생성해서 쓰면 다른 컨트롤러에서 사용할 때마다 생성되어 스프링 컨테이너에 한 번만 등록해놓고 공유해서 쓰는게 좋다

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        // memberService 에 @service 어노테이션이 없으면 스프링이 서비스라고 인식하지 못함
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
