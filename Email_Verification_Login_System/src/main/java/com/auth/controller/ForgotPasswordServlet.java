package com.auth.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.auth.Factory.PasswordResetServiceFactory;
import com.auth.Factory.UserServiceFactory;
import com.auth.Model.PasswordReset;
import com.auth.Model.User;
import com.auth.service.PasswordResetService;
import com.auth.service.UserService;
import com.auth.util.EmailService;
import com.auth.util.TokenGenerator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/forgot-password")
public class ForgotPasswordServlet extends HttpServlet 
{
	private UserService userService=UserServiceFactory.getUserServiceFactory();
	private PasswordResetService passwordResetService=PasswordResetServiceFactory.getPasswordResetServiceInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String email = request.getParameter("email");
		 Map<String, String> errors = new HashMap<>();
		 

	        if (email == null || email.trim().isEmpty()) 
	        {
	            errors.put("email", "Email is required");
	            request.setAttribute("errors", errors);
	            request.getRequestDispatcher("/WEB-INF/views/forgot-password.jsp").forward(request, response);
	            return;
	        }
		
	        
	        
	        User user = userService.findByEmail(email.trim().toLowerCase());
	        
	        // Check if email exists in database
	        if (user == null) {
	            errors.put("email", "Email not exists");
	            request.setAttribute("errors", errors);
	            request.setAttribute("email", email);
	            request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
	            return;
	        }
	        
	        // Check if account is active
	        if (user.getStatus() != User.UserStatus.ACTIVE) {
	            errors.put("email", "Please verify your email before resetting password");
	            request.setAttribute("errors", errors);
	            request.setAttribute("email", email);
	            request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
	            return;
	        }
	        
	 
	        
	        // Generate reset token
	        String token = TokenGenerator.generateToken();
	        LocalDateTime expiry = LocalDateTime.now().plusHours(1);
	        
	        // Delete any existing reset tokens for this user
	        passwordResetService.deleteByUser(user);
	        
	        PasswordReset passwordReset = new PasswordReset(user, token, expiry);
	        passwordResetService.save(passwordReset);
	        
	        // Send reset email
	        String resetLink = getBaseUrl(request) + "/reset-password?token=" + token;
	        EmailService.sendPasswordResetEmail(email, resetLink);
	        
	        request.setAttribute("success", "Password reset link has been sent to your email.");
	        request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
	        
	        

	}
	
	 private String getBaseUrl(HttpServletRequest request) {
	        String scheme = request.getScheme();
	        String serverName = request.getServerName();
	        int serverPort = request.getServerPort();
	        String contextPath = request.getContextPath();
	        
	        StringBuilder url = new StringBuilder();
	        url.append(scheme).append("://").append(serverName);
	        
	        if (serverPort != 80 && serverPort != 443) {
	            url.append(":").append(serverPort);
	        }
	        
	        url.append(contextPath);
	        return url.toString();
	    }

}
