package com.config;
 
import java.io.IOException;
import java.util.List;
 
import javax.crypto.SecretKey;
 
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorityAuthorizationDecision;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
 
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
 
public class JwtTokenValidator extends OncePerRequestFilter {
 
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jwt = request.getHeader(JwtConstants.JWT_HEADER);
		if(jwt!=null) {
			//(Bearer jwttoken) in this format token is there
			jwt=jwt.substring(7);
			try {
				SecretKey key = Keys.hmacShaKeyFor(JwtConstants.SECRET_KEY.getBytes());
				Claims claim = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
				String email = String.valueOf(claim.get("email"));
				String authorities = String.valueOf(claim.get("authorities"));
				List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
				Authentication authentication = new UsernamePasswordAuthenticationToken(email,null, auths);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} catch (Exception e) {
				throw new BadCredentialsException("Invalid token");
			}
		}
		filterChain.doFilter(request, response);
	}
 
}