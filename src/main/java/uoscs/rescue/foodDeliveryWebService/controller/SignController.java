package uoscs.rescue.foodDeliveryWebService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import uoscs.rescue.foodDeliveryWebService.data.dao.MemberDao;
import uoscs.rescue.foodDeliveryWebService.data.dto.MemberDto;
import uoscs.rescue.foodDeliveryWebService.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sign")
public class SignController {

    private final MemberService memberService;
    private static String LOGIN_ID = "login_id";

    @PostMapping("/signin")
    public ResponseEntity<String> signin(HttpServletRequest request){
        String id = request.getParameter("id");
        String password = request.getParameter("password");

        if(!memberService.checkIdAndPassword(id,password))
            return ResponseEntity.ok("fail");

        HttpSession session = request.getSession();
        session.setAttribute(LOGIN_ID, id);

        return ResponseEntity.ok("login success id= " +id);
    }

    

}
