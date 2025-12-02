# 📧 Email Verification Login System

A secure, production-ready authentication system built using **Jakarta EE**, designed with enterprise-level security, layered architecture, and email verification workflows.  
This system provides a complete authentication suite including user registration, login, email verification, password reset, role management, and strong security protections.

---

## 1️⃣ Project Title  
**Email Verification Login System**

---

## 2️⃣ Project Description  

A secure, production-grade authentication system built with **Jakarta EE MVC architecture** that implements:

- ✅ User Registration with real-time validation  
- ✅ Login Authentication with session management  
- ✅ Email Verification using secure tokens / OTP  
- ✅ Secure Password Storage using BCrypt hashing  
- ✅ Complete session handling following industry security standards  

This system ensures **enterprise-grade authentication**, password recovery, robust email verification, and layered security for modern web applications.

---

## 3️⃣ Features  

### 🔐 Core Authentication  
- User Registration with email validation  
- Email Verification (Token/OTP with expiry)  
- Secure Login & Logout (session-based)  
- Forgot Password + Reset Token flow  
- Resend Verification Email  
- Remember Me functionality (optional)

### 🛡️ Security Features  
- BCrypt Password Hashing (12 rounds)  
- Account Lockout after 5 failed attempts  
- Session Security with HttpOnly cookies  
- CSRF Protection on all POST forms  
- Input Validation & XSS Sanitization  
- SQL Injection Prevention using Hibernate ORM  
- Secure HTTP Headers  
- Session Fixation Protection  

### 📧 Email System  
- SMTP Integration with TLS support  
- HTML Email Templates  
- Verification Emails  
- Password Reset Emails  
- Configurable Email Services  

### 🏗️ Architecture  
- MVC Architecture (Servlet → Service → DAO → JSP)  
- Factory Pattern for service & DAO initialization  
- Singleton Pattern for Hibernate SessionFactory  
- Repository Pattern for clean database access  
- Layered architecture for maintainability & scalability  

---

## 4️⃣ Technology Stack  

### Backend  
- Java 17+  
- Jakarta Servlets 4.0+  
- Hibernate ORM 6.3  
- JSP 3.0  
- JSTL 2.0  

### Frontend  
- HTML5, CSS3, JavaScript  
- Bootstrap 5  
- AJAX  

### Database  
- MySQL 8.0+ / MariaDB  
- HikariCP / C3P0  

### Server & Tools  
- Apache Tomcat 10.x  
- Maven 3.8+  
- JavaMail API  
- BCrypt  

### Development Tools  
- Eclipse IDE / IntelliJ IDEA  
- Git / GitHub  
- Postman  

---

## 5️⃣ Project Folder Structure  
```
Email_Verification_Login_System/
 ├── src/
 │    ├── main/java/com/auth/
 │    │      ├── controller/
 │    │      ├── service/
 │    │      ├── dao/
 │    │      ├── model/
 │    │      ├── config/
 │    │      └── util/
 │    ├── main/resources/
 │    │      └── hibernate.cfg.xml
 │    └── main/webapp/
 │           ├── WEB-INF/
 │           │      └── web.xml
 │           ├── login.jsp
 │           ├── register.jsp
 │           ├── verify.jsp
 │           ├── forgot-password.jsp
 │           ├── reset-password.jsp
 │           └── dashboard.jsp
 ├── pom.xml
 └── README.md
```
---

## 6️⃣ How to Run the Project  

### Step 1 — Clone
```  
git clone https://github.com/aniketjumde/EmailVerificationSystem
```
### Step 2 — Import as Maven Project  

### Step 3 — Configure Database
```  
src/main/resources/hibernate.cfg.xml
```
### Step 4 — Create Tables  
(Use schema below)

### Step 5 — Configure Email SMTP
```  
EmailService.java
```
### Step 6 — Deploy on Tomcat  

### Step 7 — Access
```  
http://localhost:8080/EmailVerificationSystem/
```
---

## 7️⃣ Database Schema  
```
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(30) DEFAULT 'USER',
    status ENUM('INACTIVE','ACTIVE') DEFAULT 'INACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE email_verification (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    token VARCHAR(255) NOT NULL,
    expiry DATETIME NOT NULL
);
CREATE TABLE password_reset (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    token VARCHAR(255) NOT NULL,
    expiry DATETIME NOT NULL
);
CREATE TABLE login_attempts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(150) NOT NULL,
    attempts INT DEFAULT 0,
    last_attempt DATETIME,
    locked_until DATETIME NULL
);
```
---

## 8️⃣ Email Configuration  
```
SMTP_HOST = "smtp.gmail.com"
SMTP_PORT = "587"
SENDER_EMAIL = "your-email@gmail.com"
APP_PASSWORD = "your-app-password"
```
---

## 🧑‍💻 Developed By  
Aniket Jumde  
GitHub: https://github.com/aniketjumde  
