package com.metacoding.authblog.user;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRequest {

    // 회원가입DTO
    @Data
    public static class JoinDTO {
        private String username;
        private String password;
        private String email;

        public User toEntity(PasswordEncoder passwordEncoder) {
            // 패스워드 암호화. IoC에 넣어 비밀번호 비교
            String encPassword = passwordEncoder.encode(password);
            User user = new User(null, username, encPassword, email, null);
            System.out.println("출력확인" + encPassword); // 출력시 비밀번호 암호화
            return user;
        }
    }

    @Data
    public class LoginDTO {
        private String username;
        private String password;
    }

}
