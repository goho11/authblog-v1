package com.metacoding.authblog.board;

import com.metacoding.authblog.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final HttpSession session;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal User user) { // 유저객체를 찾는 어노테이션
        System.out.println("로그인 : " + user.getUsername());
        return "index";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {

        return "board/save-form";
    }
}
