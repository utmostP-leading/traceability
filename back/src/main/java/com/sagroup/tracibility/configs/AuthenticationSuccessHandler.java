package com.sagroup.tracibility.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagroup.tracibility.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 权限验证成功
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Component("successHandler")
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
                                        throws IOException{
        //设置返回JSON
        response.setContentType("application/json;charset=UTF-8");
        //返回登录后的用户信息
        response.getWriter().write(mapper.writeValueAsString(ResultUtil.resultGoodReturner(authentication.getPrincipal())));
    }

}
