package com.metacoding.authblog._core.filter;

import com.metacoding.authblog.user.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// 필터 만들기
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(); // 리퀘스트 객체에서 세션 가져옴

        User sessionUser = (User) session.getAttribute("sessionUser");
        if(sessionUser != null) {
            resp.sendRedirect("/login-form");
        } else {
            chain.doFilter(request, response); // null이 아니면 다음 필터로
            }
        }
    }
