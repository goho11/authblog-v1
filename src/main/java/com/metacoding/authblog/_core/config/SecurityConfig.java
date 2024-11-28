package com.metacoding.authblog._core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// 링크에 /s 들어가면 login폼 이동 설정
@Configuration
public class SecurityConfig {

    // user가 입력한 비밀번호와 DB비밀번호와 맞는지 확인
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        // csrf : 임시코드. 내가 만든 데이터 검증 가능
        http.csrf(c->c.disable());

        http.authorizeHttpRequests(r->
                r.requestMatchers("/s/**").authenticated().anyRequest().permitAll())
                    .formLogin(f->f.loginPage("/login-form")
                            .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/"));

        return http.build();
    }
}
