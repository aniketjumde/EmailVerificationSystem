package com.auth.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import com.auth.Factory.EmailVerificationServiceFactory;
import com.auth.Factory.UserServiceFactory;
import com.auth.Model.EmailVerification;
import com.auth.Model.User;
import com.auth.service.EmailVerificationService;
import com.auth.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/verify")
public class VerifyServlet extends HttpServlet 
{
	private UserService userService=UserServiceFactory.getUserServiceFactory() ;

    private EmailVerificationService emailVerificationService=EmailVerificationServiceFactory.getEmailVerificationServiceInstance();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
        String token = request.getParameter("token");
        
        if (token == null || token.trim().isEmpty()) 
        {
            request.setAttribute("error", "Invalid verification link");
            request.getRequestDispatcher("verify.jsp").forward(request, response);
            return;
        }

        EmailVerification verification=emailVerificationService.findByToken(token);
        
        
        if (verification == null) 
        {
            request.setAttribute("error", "Invalid verification token");
            request.getRequestDispatcher("/WEB-INF/views/verify.jsp").forward(request, response);
            return;
        }
        
        if (verification.getExpiry().isBefore(LocalDateTime.now())) 
        {
            request.setAttribute("error", "Verification link has expired");
            request.getRequestDispatcher("/WEB-INF/views/verify.jsp").forward(request, response);
            return;
        }
        
     // Activate user account
        User user = verification.getUser();
        user.setStatus(User.UserStatus.ACTIVE);
        userService.updateUser(user);
        
     // Remove verification token
        emailVerificationService.delete(verification);
        
        request.setAttribute("success", "Email verified successfully! You can now login to your account.");
        request.getRequestDispatcher("verify.jsp").forward(request, response);

	}

	

}
