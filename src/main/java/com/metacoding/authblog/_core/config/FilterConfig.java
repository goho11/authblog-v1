package com.metacoding.authblog._core.config;

import com.metacoding.authblog._core.filter.AuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration // IoC에 띄우기
public class FilterConfig {
    @Bean // 리턴값 IoC에 등록
    public FilterRegistrationBean addAuthFilter() {
        FilterRegistrationBean rg = new FilterRegistrationBean();
        rg.setFilter(new AuthenticationFilter());
        rg.addUrlPatterns("/board/*"); // 주소가 board 이면 허용
        rg.addUrlPatterns("/user/*");
        rg.setOrder(1); // 필터 순서 정하기

        // 해당 메서드 실행시, 리턴되는 객체를 IOC 컨테이너에 등록
        return rg;
    }
}
