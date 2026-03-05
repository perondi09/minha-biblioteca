package com.perondi.minha_biblioteca.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {

    public static final Key JWT_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long JWT_EXPIRATION = 3600000; // 1 hora

    public static String gerarToken(String nome) {
        long now = System.currentTimeMillis();
        return io.jsonwebtoken.Jwts.builder()
                .setSubject(nome)
                .setIssuedAt(new java.util.Date(now))
                .setExpiration(new java.util.Date(now + JWT_EXPIRATION))
                .signWith(JWT_KEY)
                .compact();
    }

    public static String exctractUsername(String token) {
        return Jwts.parser().setSigningKey(JWT_KEY).build()
                .parseClaimsJws(token)
                .getBosdy()
                .getSubject();
    }
}
