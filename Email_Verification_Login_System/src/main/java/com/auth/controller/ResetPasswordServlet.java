package com.auth.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.auth.Factory.LoginAttemptServiceFactory;
import com.auth.Factory.PasswordResetServiceFactory;
import com.auth.Factory.UserServiceFactory;
import com.auth.Model.PasswordReset;
import com.auth.Model.User;
import com.auth.service.LoginAttemptService;
import com.auth.service.PasswordResetService;
import com.auth.service.UserService;
import com.auth.util.PasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/reset-password")
public class ResetPasswordServlet extends HttpServlet 
{
	private UserService userService=UserServiceFactory.getUserServiceFactory();
	private PasswordResetService passwordResetService=PasswordResetServiceFactory.getPasswordResetServiceInstance();
	private LoginAttemptService loginAttemptService=LoginAttemptServiceFactory.getLoginAttemptServiceInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		 String token = request.getParameter("token");
	        
	        if (token == null || token.trim().isEmpty()) {
	            request.setAttribute("error", "Invalid reset link");
	            request.getRequestDispatcher("/WEB-INF/views/reset-password.jsp").forward(request, response);
	            return;
	        }
	        
	        PasswordReset passwordReset = passwordResetService.findByToken(token);
	        
	        if (passwordReset == null) {
	            request.setAttribute("error", "Invalid reset token");
	            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
	            return;
	        }
	        
	        if (passwordReset.getExpiry().isBefore(LocalDateTime.now())) {
	            request.setAttribute("error", "Reset link has expired");
	            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
	            return;
	        }
	        
	        request.setAttribute("token", token);
	        request.getRequestDispatcher("/reset-password.jsp").forward(request, response);	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 
        String token = request.getParameter("token");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        
        Map<String, String> errors = validateResetPassword(token, password, confirmPassword);
        
        if (!errors.isEmpty()) 
        {
            request.setAttribute("errors", errors);
            request.setAttribute("token", token);
            request.getRequestDispatcher("reset-password.jsp").forward(request, response);
            return;
        }
        
        PasswordReset passwordReset = passwordResetService.findByToken(token);
        User user = passwordReset.getUser();
        
        // Update password
        String hashedPassword = PasswordUtil.hasPassword(password);
        int userId = passwordReset.getUser().getId();
        userService.updatePassword(userId, hashedPassword);
        
        // Remove reset token
        passwordResetService.delete(passwordReset);
        
        // Reset login attempts
        String email = passwordResetService.getEmailByToken(token);
        loginAttemptService.resetAttempts(email);

        request.setAttribute("success", "Password reset successfully! You can now login with your new password.");
        request.getRequestDispatcher("reset-password.jsp").forward(request, response);
    }
    
    private Map<String, String> validateResetPassword(String token, String password, String confirmPassword) {
        Map<String, String> errors = new HashMap<>();
        
        if (token == null || token.trim().isEmpty()) {
            errors.put("general", "Invalid reset token");
            return errors;
        }
        
        PasswordReset passwordReset = passwordResetService.findByToken(token);
        if (passwordReset == null) {
            errors.put("general", "Invalid reset token");
            return errors;
        }
        
        if (passwordReset.getExpiry().isBefore(LocalDateTime.now())) {
            errors.put("general", "Reset token has expired");
            return errors;
        }
        
        if (password == null || password.isEmpty()) {
            errors.put("password", "Password is required");
        } else if (!PasswordUtil.isStrongPassword(password)) {
            errors.put("password", "Password must be at least 8 characters with uppercase, lowercase, digit, and special character");
        }
        
        if (!password.equals(confirmPassword)) {
            errors.put("confirmPassword", "Passwords do not match");
        }
        
        return errors;
    }
	

}
