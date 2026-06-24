package com.eventflow.userservice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.eventflow.userservice.domain.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    public String gerarToken(User user){
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create().withIssuer("eventflow")
                    .withSubject(user.getId().toString())
                    .withClaim("role", user.getUserRole().name())
                    .withExpiresAt(Instant.now().plusSeconds(86400))
                    .withIssuedAt(Instant.now())
                    .sign(algorithm);
    }

    public String validaToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.require(algorithm).withIssuer("eventflow")
                .build()
                .verify(token)
                .getSubject();
    }




}
