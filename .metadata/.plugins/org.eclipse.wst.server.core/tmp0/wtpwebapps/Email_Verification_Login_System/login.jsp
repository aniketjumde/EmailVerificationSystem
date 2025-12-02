<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - MVC Auth</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body { font-family: Arial, sans-serif; background: #f5f5f5; padding: 20px; }
        .container { max-width: 400px; margin: 100px auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
        h2 { text-align: center; margin-bottom: 20px; color: #333; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; color: #555; }
        input[type="email"], input[type="password"] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; font-size: 14px; }
        button { width: 100%; padding: 12px; background: #28a745; color: white; border: none; border-radius: 4px; font-size: 16px; cursor: pointer; }
        button:hover { background: #218838; }
        .error { color: #dc3545; font-size: 12px; margin-top: 5px; }
        .register-link, .forgot-link { text-align: center; margin-top: 15px; }
        .register-link a, .forgot-link a { color: #007bff; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login to Your Account</h2>
        
        <form action="login" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${email}" required>
                <c:if test="${not empty errors.email}">
                    <div class="error">${errors.email}</div>
                </c:if>
            </div>
            
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
                <c:if test="${not empty errors.password}">
                    <div class="error">${errors.password}</div>
                </c:if>
            </div>
            
            <c:if test="${not empty errors.general}">
                <div class="error">${errors.general}</div>
            </c:if>
            
            <button type="submit">Login</button>
        </form>
        
        <div class="forgot-link">
            <a href="forgot-password">Forgot Password?</a>
        </div>
        
        <div class="register-link">
            Don't have an account? <a href="register">Register here</a>
        </div>
    </div>
</body>
</html>