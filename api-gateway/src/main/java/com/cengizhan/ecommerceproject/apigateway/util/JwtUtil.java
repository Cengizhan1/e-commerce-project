package com.cengizhan.ecommerceproject.apigateway.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.Key;

@Service
public class JwtUtil {

  @Value("${application.security.jwt.secret-key}")
  private String secretKey;


  public void validateToken(final String token) {
    Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token);
  }
  private Key getSignInKey() {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
