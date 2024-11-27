package com.metacoding.authblog.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor // 풀생성자
@NoArgsConstructor
@Table(name = "user_tb")
@Getter
@Entity // pk설정 필요
public class User {
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
}
