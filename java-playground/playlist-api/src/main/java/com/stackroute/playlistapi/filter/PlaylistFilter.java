package com.stackroute.playlistapi.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;

public class PlaylistFilter extends GenericFilter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		
		if(httprequest.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name())) {
			chain.doFilter(httprequest, httpresponse);
		}
		else {
			String header = httprequest.getHeader("Authorization");
			if( (header==null) || (!header.startsWith("Bearer"))) {
				throw new ServletException("Token Not provided");
			}
			else {
				String tokenpassed = header.substring(7);
				try {
					JwtParser myparser = Jwts.parser().setSigningKey("allstatekey");
					Jwt jwobj = myparser.parse(tokenpassed);
					Claims claimobj = (Claims) jwobj.getBody();
					System.out.println(claimobj.getSubject());
				} catch (MalformedJwtException e) {
					throw new ServletException("Jwt token is modifide. Invalid");
				} catch(Exception e) {
					throw new ServletException("Token not valid");
				}
			}
			
			chain.doFilter(httprequest, httpresponse);
		}
	}

}
