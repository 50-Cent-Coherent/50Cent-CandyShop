package coherent.practica.candyshop.config;

import coherent.practica.candyshop.model.CustomUserDetails;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.Getter;
import com.auth0.jwt.JWT;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
public class JwtTokenGenerator {
    SecurityProperties securityProperties;

    public JwtTokenGenerator(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }

    public String generateTokenWithPrefix(CustomUserDetails customUserDetails) {
        return securityProperties.getTokenPrefix() + generateToken(customUserDetails);
    }

    public String generateToken(CustomUserDetails customUserDetails) {
        return JWT.create()
                .withSubject(customUserDetails.getUsername())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + securityProperties.getTokenExpirationTime()))
                .sign(Algorithm.HMAC512(securityProperties.getSecret().getBytes()));
    }

    public String getAccountFromToken(String token){
        return JWT.require(Algorithm.HMAC512(securityProperties.getSecret().getBytes()))
                .build()
                .verify(token.replace(securityProperties.getTokenPrefix(),""))
                .getSubject();
    }
}