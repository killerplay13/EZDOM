package tw.com.cha102.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tw.com.cha102.member.dto.CommonResponse;
import tw.com.cha102.member.dto.LoginRequest;
import tw.com.cha102.member.dto.SignUpRequest;
import tw.com.cha102.member.model.entity.Member;
import tw.com.cha102.member.service.MemberService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/member")
@CrossOrigin("*")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private HttpSession httpSession;

    @PostMapping("/login")
    public CommonResponse<String> login(@RequestBody @Valid LoginRequest loginRequest,
                                        HttpServletRequest request,
                                        HttpServletResponse response) {
        memberService.login(loginRequest,request,response);
        return new CommonResponse("登入成功");
    }

    @PostMapping("/signUp")
    public  CommonResponse<String> signUp(@RequestBody @Valid SignUpRequest signUpRequest){
        memberService.signUp(signUpRequest);
        return  new CommonResponse("註冊成功");
    }

    @GetMapping("/member")
    public List<Member> getMembers(){
        return memberService.getMembers();
    }
}
