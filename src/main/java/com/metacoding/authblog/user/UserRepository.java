package com.metacoding.authblog.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository { // DB조회해서 가져오기
    private final EntityManager em;

    public User findByUsername(String username) {
        // 유저클래스로 바로 캐스팅
        Query q = em.createQuery("select u from User u where u.username = :username", User.class); // JPQL쿼리문
        q.setParameter("username", username);
        try {
            return (User) q.getSingleResult();
        } catch (RuntimeException e) {
                throw new RuntimeException("아이디 혹은 패스워드가 일치하지 않습니다");
        }
    }

    // User 객체를 DB저장
    public User save(User user) {
        em.persist(user);
        return user;
    }
}
