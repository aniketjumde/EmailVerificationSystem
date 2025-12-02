<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password - MVC Auth</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body { font-family: Arial, sans-serif; background: #f5f5f5; padding: 20px; }
        .container { max-width: 400px; margin: 100px auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }
        h2 { text-align: center; margin-bottom: 20px; color: #333; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; color: #555; }
        input[type="email"] { width: 100%; padding: 10px; border: 1px solid #ddd; border-radius: 4px; font-size: 14px; }
        button { width: 100%; padding: 12px; background: #ffc107; color: #333; border: none; border-radius: 4px; font-size: 16px; cursor: pointer; }
        button:hover { background: #e0a800; }
        .error { color: #dc3545; font-size: 12px; margin-top: 5px; }
        .success { color: #28a745; background: #d4edda; padding: 10px; border-radius: 4px; margin-bottom: 15px; }
        .login-link { text-align: center; margin-top: 20px; }
        .login-link a { color: #007bff; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Forgot Password</h2>
        
        <c:if test="${not empty success}">
            <div class="success">${success}</div>
        </c:if>
        
        <form action="forgot-password" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" value="${email}" required>
                <c:if test="${not empty errors.email}">
                    <div class="error">${errors.email}</div>
                </c:if>
            </div>
            
            <c:if test="${not empty errors.general}">
                <div class="error">${errors.general}</div>
            </c:if>
            
            <button type="submit">Send Reset Link</button>
        </form>
        
        <div class="login-link">
            <a href="login">Back to Login</a>
        </div>
    </div>
</body>
</html>