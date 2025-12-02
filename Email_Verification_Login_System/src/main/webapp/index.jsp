<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Authentication System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        
        .container {
            text-align: center;
            background: white;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            width: 300px;
        }
        
        h1 {
            color: #333;
            margin-bottom: 30px;
        }
        
        .button {
            display: block;
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            text-decoration: none;
            color: white;
            border-radius: 4px;
            font-weight: bold;
            text-align: center;
        }
        
        .login-btn {
            background: #007bff;
        }
        
        .login-btn:hover {
            background: #0056b3;
        }
        
        .register-btn {
            background: #28a745;
        }
        
        .register-btn:hover {
            background: #218838;
        }
        
        .message {
            margin-top: 20px;
            color: #666;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="title">Authentication System</div>
        <div class="subtitle">Secure User Management</div>
        
        <a href="${pageContext.request.contextPath}/login" class="button login-btn">
            🔐 Login to Account
        </a>
        
        <a href="${pageContext.request.contextPath}/register" class="button register-btn">
            📝 Create New Account
        </a>
        
        <div class="message">
            Built with Java Servlet & Hibernate
        </div>
    </div>
</body>
</html>