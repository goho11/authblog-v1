package com.metacoding.authblog.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor // 풀생성자
@NoArgsConstructor
@Table(name = "user_tb")
@Getter
@Entity // pk설정 필요
public class User implements UserDetails {
    @Id // pk설정함
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 오토인~ 설정
    private Integer id; // 번호 붙이기용

    @Column(unique = true, nullable = false)
    private String username; // 아이디
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;

    @CreationTimestamp
    private Timestamp createdAt;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // -- 1128 시큐리터 user 반환을 위해 메서드 5개 생성
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // 사용자 권한 반환
        return List.of();
    }

    @Override
    public boolean isAccountNonExpired() { // 계정 유효 기간 확인
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정 잠김 확인
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 인증 자격 증명(ex.일정 기간마다 비밀번호 변경 요청)
        return true;
    }

    @Override
    public boolean isEnabled() { // 계정 활성화 상태 확인(또는 비활성화 설정)
        return true;
    }
}
