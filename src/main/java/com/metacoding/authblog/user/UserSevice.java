package com.metacoding.authblog.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSevice implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void 회원가입(UserRequest.JoinDTO joinDTO) {
        userRepository.save(joinDTO.toEntity(passwordEncoder));
    }

    // POST 요청
    // /login 호출됨
    // key 값 -> username, password
    // Content-Type -> x-www-form-urlencoded
    // username을 받아 사용자 조회
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        return user; // User에 반환값 받기
    }
}
