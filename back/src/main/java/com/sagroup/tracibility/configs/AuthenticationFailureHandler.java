package com.sagroup.tracibility.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sagroup.tracibility.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 权限验证失败
 * @Author: 潘浩霖
 * @Date: 2018/12/29
 */
@Component("failureHandler")
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Autowired
    private ObjectMapper mapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
                                        throws IOException{

        //设置返回JSON
        response.setContentType("application/json;charset=UTF-8");

        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        if(exception.getMessage().contains("坏的凭证")){
            response.getWriter().write(mapper.writeValueAsString(ResultUtil.resultBadReturner("用户名或密码错误")));
        }else{
            response.getWriter().write(mapper.writeValueAsString(ResultUtil.resultBadReturner("用户不存在")));
        }

    }
}
