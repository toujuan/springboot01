package com.situ.crm2026.common;

import com.alibaba.fastjson2.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.situ.crm2026.util.JsonResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        //取出jwt
        String jwt = req.getHeader("Authorization");
        //核验器
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(jwtSecret)).build();
        //获取解密后的jwt
        try {
            DecodedJWT dj = verifier.verify(jwt);
            //成功
            //String username = dj.getAudience().getFirst();
            return true;
        } catch (JWTVerificationException e) {
            //失败
            String msg = "jwt无效或过期";
            resp.setStatus(HttpStatus.UNAUTHORIZED.value());//401
            resp.setContentType("application/json;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.write(JSON.toJSONString(JsonResult.fail(401, msg)));
            out.flush();
            return false;
        }
    }
}
