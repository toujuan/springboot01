package com.situ.crm2026.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

public class JwtUtils {
    //创建jwt
    public static String createJwt(String id, String username, Map<String, Object> payloads,
                                   LocalDateTime expireTime, String secret) {
        JWTCreator.Builder builder = JWT.create();
        String jwt = builder.withPayload(payloads)
                .withExpiresAt(expireTime.toInstant(ZoneOffset.of("+8")))
                .withIssuer("中享思途")
                .withIssuedAt(Instant.now())
                .withSubject("身份认证")
                .withAudience(username)
                .withJWTId(id)
                .sign(Algorithm.HMAC256(secret));
        return jwt;
    }
}
