package com.stackroute.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.GenericFilterBean;


import java.io.IOException;

/* This class implements the custom filter by extending org.springframework.web.filter.GenericFilterBean.
 * Override the doFilter method with ServletRequest, ServletResponse and FilterChain.
 * This is used to authorize the API access for the application.
 */
public class JwtUserFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods","POST,GET,PUT,DELETE,OPTIONS");


        final String authHeader = request.getHeader("authorization");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
        } else {
            /*
             * Check if authHeader is null or does not start with "Bearer " then throw Exception
             */
            if(authHeader!=null && !(authHeader.startsWith("Bearer"))){
                throw new ServletException("JWT Token is missing");
            }
            /*
             * Extract token from authHeader
             */
            String jwtToken = authHeader.substring(7);

            /*
             * Obtain Claims by parsing the token with the signing key value "secret"
             */
            JwtParser jwtParser= Jwts.parser().setSigningKey("secret");
            Jwt obj = jwtParser.parse(jwtToken);
            Claims claims = (Claims)obj.getBody();

            /*
             * Extract role from Claims and check if it is "user" or "admin" and then allow only USER Role
             */
            String role = claims.get("role", String.class);
            if(!role.equalsIgnoreCase("user")){
                throw new ServletException("Not User role");
            }
            /*
             * Set Claims object obtained in previous step with key "claims" as request attribute
             */
            request.setAttribute("claims", claims);
            /*
             * Set user id passed as request parameter with key "user" as request attribute
             */
            request.setAttribute("user", claims.getSubject());
            filterChain.doFilter(request, response);
        }
    }
}

