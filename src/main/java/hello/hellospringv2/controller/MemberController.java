package hello.hellospringv2.controller;

import hello.hellospringv2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    // new 로 생성해서 쓰면 다른 컨트롤러에서 사용할 때마다 생성되어 스프링 컨테이너에 한 번만 등록해놓고 공유해서 쓰는게 좋다

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        // memberService 에 @service 어노테이션이 없으면 스프링이 서비스라고 인식하지 못함
    }
}
