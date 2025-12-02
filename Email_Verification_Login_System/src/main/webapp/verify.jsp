<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Email Verification - MVC Auth</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        * { box-sizing: border-box; margin: 0; padding: 0; }
        body { font-family: Arial, sans-serif; background: #f5f5f5; padding: 20px; }
        .container { max-width: 500px; margin: 100px auto; background: white; padding: 30px; border-radius: 8px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); text-align: center; }
        h2 { margin-bottom: 20px; color: #333; }
        .success { color: #28a745; background: #d4edda; padding: 15px; border-radius: 4px; margin-bottom: 20px; }
        .error { color: #dc3545; background: #f8d7da; padding: 15px; border-radius: 4px; margin-bottom: 20px; }
        .login-link { margin-top: 20px; }
        .login-link a { color: #007bff; text-decoration: none; font-size: 16px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Email Verification</h2>
        
        <c:if test="${not empty success}">
            <div class="success">${success}</div>
        </c:if>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        
        <div class="login-link">
            <a href="login">Go to Login</a>
        </div>
    </div>
</body>
</html>