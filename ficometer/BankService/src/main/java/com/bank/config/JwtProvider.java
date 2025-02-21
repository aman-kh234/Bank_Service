package com.bank.config;
 
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
 
import javax.crypto.SecretKey;
 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
 
 
@Service
public class JwtProvider {
    private static final SecretKey key = Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());
    public static String generateToken(Authentication auth) {
    	Collection<? extends GrantedAuthority>authorities = auth.getAuthorities(); 
    	String roles = populateAuthorities(authorities);
    	return Jwts.builder().setIssuedAt(new Date())
    			.setExpiration(new Date(new Date().getTime()+86400000))
    			.claim("email",auth.getName())
    			.claim("authorities", roles)
    			.signWith(key)
    			.compact();
    }
    public static String getEmailFromJwtToken(String token) {
    	token = token.substring(7);
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
        String email = String.valueOf(claims.get("email"));
        return email;
    }
	private static String populateAuthorities(Collection<? extends GrantedAuthority> authorities) {
		Set<String> auths = new HashSet<>();
		for( GrantedAuthority authority : authorities) {
			auths.add(authority.getAuthority());
		}
		return String.join(",",auths);
	}
}