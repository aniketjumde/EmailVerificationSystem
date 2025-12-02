package com.auth.controller;

import java.io.IOException;

import com.auth.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		  HttpSession session = request.getSession(false);
	        if (session == null || session.getAttribute("user") == null) 
	        {
	            response.sendRedirect(request.getContextPath() + "/login");
	            return;
	        }
	        
	        User user = (User) session.getAttribute("user");
	        request.setAttribute("user", user);
	        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}

	

}
