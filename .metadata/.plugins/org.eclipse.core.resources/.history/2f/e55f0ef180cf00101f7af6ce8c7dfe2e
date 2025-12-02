package com.auth.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.auth.Factory.LoginAttemptServiceFactory;
import com.auth.Factory.UserServiceFactory;
import com.auth.Model.LoginAttempt;
import com.auth.Model.User;
import com.auth.service.LoginAttemptService;
import com.auth.service.UserService;
import com.auth.util.PasswordUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet 
{
	private UserService userService=UserServiceFactory.getUserServiceFactory();
	private LoginAttemptService loginAttemptService=LoginAttemptServiceFactory.getLoginAttemptServiceInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  HttpSession session = request.getSession(false);
	      if (session != null && session.getAttribute("user") != null) 
	      {
	          response.sendRedirect(request.getContextPath() + "/dashboard");
	          return;
	      }
	      request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
        Map<String, String> errors = validateLogin(email, password);
        
        if (!errors.isEmpty()) 
        {
            request.setAttribute("errors", errors);
            request.setAttribute("email", email);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        // Check login attempts
        LoginAttempt attempt = loginAttemptService.findByEmail(email);
        if (attempt != null && attempt.getLockedUntil() != null && 
            attempt.getLockedUntil().isAfter(LocalDateTime.now())) 
        {
            errors.put("general", "Account temporarily locked. Try again later.");
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        User user=userService.findByEmail(email);
        
        if (user == null || !PasswordUtil.checkPassword(password, user.getPassword())) 
        {
            handleFailedLogin(email, attempt);
            errors.put("general", "Invalid email or password");
            request.setAttribute("errors", errors);
            request.setAttribute("email", email);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        if (user.getStatus() != User.UserStatus.ACTIVE) 
        {
            errors.put("general", "Please verify your email before logging in");
            request.setAttribute("errors", errors);
            request.setAttribute("email", email);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        
        // Successful login

        loginAttemptService.resetAttempts(email);
        
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("userId", user.getId());
        session.setAttribute("userEmail", user.getEmail());
        session.setAttribute("userName", user.getName());
        session.setMaxInactiveInterval(30 * 60); // 30 minutes
        
        response.sendRedirect(request.getContextPath() + "/dashboard");

	}



	private void handleFailedLogin(String email, LoginAttempt attempt) 
	{
        if (attempt == null) {
            attempt = new LoginAttempt(email);
        }
        
        attempt.setAttempts(attempt.getAttempts() + 1);
        attempt.setLastAttempt(LocalDateTime.now());
        
        if (attempt.getAttempts() >= 5) {
            attempt.setLockedUntil(LocalDateTime.now().plusMinutes(15));
        }
        
        loginAttemptService.saveOrUpdate(attempt);
    }



	private Map<String, String> validateLogin(String email, String password) {
        Map<String, String> errors = new HashMap<>();
        
        if (email == null || email.trim().isEmpty()) {
            errors.put("email", "Email is required");
        }
        
        if (password == null || password.isEmpty()) {
            errors.put("password", "Password is required");
        }
        
        return errors;
    }

}
