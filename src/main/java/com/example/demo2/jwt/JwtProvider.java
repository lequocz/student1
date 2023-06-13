package com.example.demo2.jwt;

import com.example.demo2.model.StudentUserDetail;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.net.Authenticator;
import java.util.Date;
@Component
public class JwtProvider {
    String key = "quoc1234";
    Date date = new Date();

    public String createToken(Authentication authentication) {
        StudentUserDetail studentUserDetail = (StudentUserDetail) authentication.getPrincipal();
        String token = Jwts.builder().setSubject(studentUserDetail.getUsername())
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime() + 5000000)).signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return token;
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException e) {
            return false;
        } catch (UnsupportedJwtException e) {
            return false;
        } catch (MalformedJwtException e) {
            return false;
        }
    }
    public String getUserNameByToken(String token){
        String username= Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
        return username;
    }
}
