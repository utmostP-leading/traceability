package com.sagroup.tracibility.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagroup.tracibility.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2019/1/3
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthenticationSuccessHandler successHandler;
    @Autowired
    AuthenticationFailureHandler failureHandler;
    @Autowired
    MyLogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected  void configure(HttpSecurity http) throws Exception{
        http.formLogin()    //定义当需要用户登录的时候，转到的登录页
            .loginProcessingUrl("/login")
            .successHandler(successHandler)
            .failureHandler(failureHandler)
            .and()
            .authorizeRequests() //定义哪些URL要被保护
            .antMatchers("/login").permitAll()
            .antMatchers("/register").permitAll()
            .anyRequest()   //登录后可以进行任意请求
            .authenticated()
            .and()
            .csrf().disable().cors().disable(); //csrf禁用！很重要！
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("logoutSucceed")
                .logoutSuccessHandler(logoutSuccessHandler);
        http.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
            @Autowired
            ObjectMapper mapper;

            @Override
            public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException{
//                httpServletResponse.getWriter().write(mapper.writeValueAsString(ResultUtil.resultBadReturner("未登录")));
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                StringBuffer sb = new StringBuffer();
                sb.append("{\"errCode\":1,\"msg\":\"未登录\",\"data\":null}");
                out.write(sb.toString());
                out.flush();
                out.close();
            }

        });
    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
