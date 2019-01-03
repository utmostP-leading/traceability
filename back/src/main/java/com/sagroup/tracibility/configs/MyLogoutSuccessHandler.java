package com.sagroup.tracibility.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagroup.tracibility.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:
 * @Author: 潘浩霖
 * @Date: 2019/1/3
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    private ObjectMapper mapper;
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response,
                                Authentication authentication) throws IOException{
        response.setStatus(200);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(mapper.writeValueAsString(ResultUtil.resultReturner(1,"登出成功",null)));
    }
}
