package com.org.espire.spring.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.espire.spring.config.AuthenticationConstant;
import com.org.espire.spring.model.Employee;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;

		//This method sets the default login URL to the provided parameter
		//If remove this line, Spring Security creates the “/login” endpoint by default
        setFilterProcessesUrl("/api/user/login");
	}

	//Authenticate the credentials
	// when the user tries to log in to our application
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			
			//// Reading incoming authentication properties
			Employee creds = new ObjectMapper().readValue(
					request.getInputStream(), Employee.class);
			
			//try to authenticate with incoming request
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					creds.getUsername(),
					creds.getPassword(), 
					new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//creating token
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String token = JWT.create()
				.withSubject(((User) auth.getPrincipal()).getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + AuthenticationConstant.EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(AuthenticationConstant.SECRET.getBytes()));
		
		 String body = ((User) auth.getPrincipal()).getUsername() + " " + token;

	        response.getWriter().write(body);
	        response.getWriter().flush();
		
	}
}
