package com.metacoding.authblog.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Optional;

// 4-2. 유저 쿼리문 테스트
// UserRepository 만 테스트 해도 됨
@Import(UserRepository.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUsername_test() {
        // given
        String username = "ssar";

        // when
        User user = userRepository.findByUsername(username);

        // then
        Assertions.assertThat(user).isNotNull();
    }
}
