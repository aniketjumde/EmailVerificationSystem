package com.auth.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.auth.Factory.EmailVerificationServiceFactory;
import com.auth.Factory.UserServiceFactory;
import com.auth.Model.EmailVerification;
import com.auth.Model.User;
import com.auth.service.EmailVerificationService;
import com.auth.service.UserService;
import com.auth.util.EmailService;
import com.auth.util.PasswordUtil;
import com.auth.util.TokenGenerator;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet 
{
	private UserService userService=UserServiceFactory.getUserServiceFactory() ;

    private EmailVerificationService emailVerificationService=EmailVerificationServiceFactory.getEmailVerificationServiceInstance();
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("register.jsp").forward(request, response);
;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 String name = request.getParameter("name");
	     String email = request.getParameter("email");
	     String password = request.getParameter("password");
	     String confirmPassword = request.getParameter("confirmPassword");
	     
	     
	     Map<String, String> errors = validateRegistration(name, email, password, confirmPassword);
	     
	     
	        if (!errors.isEmpty()) 
	        {
	            request.setAttribute("errors", errors);
	            request.setAttribute("name", name);
	            request.setAttribute("email", email);
	            request.getRequestDispatcher("register.jsp").forward(request, response);
	            return;
	        }
	        
	        try
	        {
	        	//Hash Passwors and create user
	        	String hashPassword=PasswordUtil.hasPassword(password);
	        	User user=new User(name,email,hashPassword);
	        	Integer userId=userService.saveUser(user);
	        	
	        	if(userId!=null)
	        	{
	        		String token=TokenGenerator.generateToken();
	        		LocalDateTime expiry=LocalDateTime.now().plusHours(24);
	        		
	        		User savedUser=userService.findById(userId);
	                EmailVerification verification = new EmailVerification(savedUser, token, expiry);
	                
	                emailVerificationService.save(verification);
	                
	                
	                // Send verification email
	                
	                String verificationLink = getBaseUrl(request) + "/verify?token=" + token;
	                EmailService.sendVerificationEmail(email, verificationLink);
	                
	                
	                request.setAttribute("success", "Registration successful! Please check your email to verify your account.");
	                request.getRequestDispatcher("register.jsp").forward(request, response);

	        	}
	        	else 
	        	{
	                errors.put("general", "Registration failed. Please try again.");
	                request.setAttribute("errors", errors);
	                request.getRequestDispatcher("register.jsp").forward(request, response);
	        	}
	        	
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	            errors.put("general", "An error occurred during registration. Please try again.");
	            request.setAttribute("errors", errors);
	            request.getRequestDispatcher("register.jsp").forward(request, response);

	        }
	        
	}


	


	private Map<String, String> validateRegistration(String name, String email, String password,String confirmPassword) 
	{
		 Map<String, String> errors = new HashMap<>();
	        
	        if (name == null || name.trim().isEmpty()) 
	        {
	            errors.put("name", "Name is required");
	        } 
	        else if (name.trim().length() < 2) 
	        {
	            errors.put("name", "Name must be at least 2 characters long");
	        }
	        
	        if (email == null || email.trim().isEmpty()) 
	        {
	            errors.put("email", "Email is required");
	        } 
	        else if (!isValidEmail(email)) 
	        {
	            errors.put("email", "Invalid email format");
	        } 
	        else if (userService.isEmailExists(email)) 
	        {
	            errors.put("email", "Email already registered");
	        }
	        
	        if (password == null || password.isEmpty()) 
	        {
	            errors.put("password", "Password is required");
	        } 
	        else if (!PasswordUtil.isStrongPassword(password)) 
	        {
	            errors.put("password", "Password must be at least 8 characters with uppercase, lowercase, digit, and special character");
	        }
	        
	        if (!password.equals(confirmPassword)) 
	        {
	            errors.put("confirmPassword", "Passwords do not match");
	        }
	        
	        return errors;
		
	}


	private boolean isValidEmail(String email) 
	{
		  String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	        return Pattern.compile(emailRegex).matcher(email).matches();
	}

		
	private String getBaseUrl(HttpServletRequest request) 
	{
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
