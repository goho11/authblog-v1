package com.metacoding.authblog.board;

import com.metacoding.authblog.user.User;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final HttpSession session;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {

        // 인증 방법 (부가로직)
        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser == null) {
            throw new RuntimeException("인증되지 않음 401");
        }

        return "board/save-form";
    }
}
