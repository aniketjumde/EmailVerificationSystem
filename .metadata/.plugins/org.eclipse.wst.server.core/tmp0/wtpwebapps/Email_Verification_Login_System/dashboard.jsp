<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Dashboard</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Arial, sans-serif;
        }
        
        body {
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }
        
        .header {
            width: 100%;
            max-width: 800px;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        
        .header h1 {
            color: #2c3e50;
            font-size: 24px;
        }
        
        .logout-btn {
            background: #e74c3c;
            color: white;
            padding: 8px 20px;
            text-decoration: none;
            border-radius: 5px;
            font-weight: 500;
            transition: background 0.3s;
        }
        
        .logout-btn:hover {
            background: #c0392b;
        }
        
        .dashboard-container {
            width: 100%;
            max-width: 800px;
        }
        
        .welcome-card {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        
        .welcome-card h2 {
            color: #2c3e50;
            margin-bottom: 10px;
            font-size: 22px;
        }
        
        .welcome-card p {
            color: #7f8c8d;
            margin-bottom: 20px;
        }
        
        .user-info-card {
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
        }
        
        .user-info-card h3 {
            color: #2c3e50;
            margin-bottom: 20px;
            padding-bottom: 10px;
            border-bottom: 2px solid #ecf0f1;
            font-size: 20px;
        }
        
        .info-row {
            display: flex;
            margin-bottom: 15px;
            padding-bottom: 15px;
            border-bottom: 1px solid #ecf0f1;
        }
        
        .info-label {
            width: 150px;
            font-weight: 600;
            color: #34495e;
        }
        
        .info-value {
            flex: 1;
            color: #2c3e50;
        }
        
        .status-badge {
            display: inline-block;
            padding: 4px 12px;
            border-radius: 20px;
            font-size: 14px;
            font-weight: 500;
        }
        
        .status-active {
            background: #d4edda;
            color: #155724;
        }
        
        .status-inactive {
            background: #f8d7da;
            color: #721c24;
        }
        
        .role-badge {
            background: #d6eaf8;
            color: #1b4f72;
            padding: 4px 12px;
            border-radius: 20px;
            font-size: 14px;
            font-weight: 500;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>User Dashboard</h1>
        <a href="logout" class="logout-btn">Logout</a>
    </div>
    
    <div class="dashboard-container">
        <div class="welcome-card">
            <h2>Welcome, ${user.name}!</h2>
            <p>Your account information is displayed below.</p>
        </div>
        
        <div class="user-info-card">
            <h3>Account Details</h3>
            
            <div class="info-row">
                <div class="info-label">Full Name:</div>
                <div class="info-value">${user.name}</div>
            </div>
            
            <div class="info-row">
                <div class="info-label">Email Address:</div>
                <div class="info-value">${user.email}</div>
            </div>
            
            <div class="info-row">
                <div class="info-label">Account Role:</div>
                <div class="info-value">
                    <span class="role-badge">${user.role}</span>
                </div>
            </div>
            
            <div class="info-row">
                <div class="info-label">Account Status:</div>
                <div class="info-value">
                    <span class="status-badge ${user.status == 'ACTIVE' ? 'status-active' : 'status-inactive'}">
                        ${user.status}
                    </span>
                </div>
            </div>
            
            <div class="info-row">
                <div class="info-label">Member Since:</div>
                <div class="info-value">${user.createdAt}</div>
            </div>
            
            <div class="info-row" style="border-bottom: none; margin-bottom: 0; padding-bottom: 0;">
                <div class="info-label">User ID:</div>
                <div class="info-value">${user.id}</div>
            </div>
        </div>
    </div>
</body>
</html>