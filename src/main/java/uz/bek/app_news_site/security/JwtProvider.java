package uz.bek.app_news_site.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import uz.bek.app_news_site.entity.Role;

import java.util.Date;

@Component
public class JwtProvider {

    private static final long expireTime = 1000*60*60*24;
    private static final String key = "secretKey";

    public String generateToken(String username, Role roleSet){
        Date expireDate = new Date(System.currentTimeMillis() + expireTime);
        String token = Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expireDate)
                .claim("roles", roleSet)
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return token;
    }

    public boolean validateToken(String token){
        try{
            Jwts
                    .parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String getUsernameFromToken(String token){
        String subject = Jwts
                .parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return subject;
    }
}
