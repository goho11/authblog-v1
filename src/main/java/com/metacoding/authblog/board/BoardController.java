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
    public String index() { // 유저객체를 찾는 어노테이션

        return "index";
    }

    @GetMapping("/s/board/save-form")
    public String saveForm(@AuthenticationPrincipal User user) {
        System.out.println("로그인 : " + user.getUsername());
        return "board/save-form";
    }
}
