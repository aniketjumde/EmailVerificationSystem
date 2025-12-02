package com.auth.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebFilter("/*")
public class AuthFilter extends HttpFilter implements Filter 
{
	  @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException 
	  {
	        
	        HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        
	        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
	        
	        HttpSession session = httpRequest.getSession(false);
	        boolean loggedIn = (session != null && session.getAttribute("user") != null);
	        
	        // Public paths that don't require authentication
	        boolean isPublicPath = path.equals("/login") || 
	                              path.equals("/register") || 
	                              path.equals("/forgot-password") ||
	                              path.equals("/reset-password") ||
	                              path.equals("/verify") ||
	                              path.startsWith("/resources/") ||
	                              path.equals("/");
	        
	        if (loggedIn && (path.equals("/login") || path.equals("/register"))) 
	        {
	            // Redirect logged-in users away from login/register pages
	            httpResponse.sendRedirect(httpRequest.getContextPath() + "/dashboard");
	            return;
	        }
	        
	        if (!loggedIn && !isPublicPath) 
	        {
	            // Redirect non-logged-in users to login page
	            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
	            return;
	        }
	        
	        // Set security headers
	        httpResponse.setHeader("X-Content-Type-Options", "nosniff");
	        httpResponse.setHeader("X-Frame-Options", "DENY");
	        httpResponse.setHeader("X-XSS-Protection", "1; mode=block");
	        httpResponse.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains");
	        
	        chain.doFilter(request, response);
	    }
	    
	    @Override
	    public void init(FilterConfig filterConfig) throws ServletException {}
	    
	    @Override
	    public void destroy() {}

}
