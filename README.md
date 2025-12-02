
# 📧 Email Verification Login System

## 1️⃣ Project Title  
**Email Verification Login System**

## 2️⃣ Project Description  
A secure Java-based authentication system that provides:

- User Registration  
- Login Authentication  
- Email Verification using OTP / Secure Token  
- Secure Password Hashing  
- Session Handling for authenticated users  

## 3️⃣ Features  

✔ User Registration  
✔ Email OTP / Token Verification  
✔ Login after successful verification  
✔ Resend Verification Email  
✔ Forgot Password & Reset Password  
✔ Secure Password Hashing (BCrypt)  
✔ Logout Functionality  
✔ Input Validation (email, password, fields)  
✔ MVC Architecture (Servlet + JSP + DAO + Service)  

## 4️⃣ Technology Stack  

- Java (Servlet/JSP)
- JSP / JSTL
- Hibernate / JDBC
- MySQL Database
- JavaMail API
- Apache Tomcat Server
- HTML, CSS, JavaScript

## 5️⃣ Project Folder Structure  

```
Email_Verification_Login_System/
 ├── src/
 │    ├── main/java/com/auth/
 │    │      ├── controller/
 │    │      ├── dao/
 │    │      ├── service/
 │    │      ├── config/
 │    │      ├── util/
 │    │      └── model/
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

## 6️⃣ How to Run the Project  

### ✔ Step 1 — Clone Repository  
```
git clone https://github.com/aniketjumde/EmailVerificationSystem
```

### ✔ Step 2 — Import into IDE  
Import as **Maven Project** in Eclipse / IntelliJ.

### ✔ Step 3 — Configure Database  
Edit your DB credentials in:
```
src/main/resources/hibernate.cfg.xml
```

### ✔ Step 4 — Create Required Tables  
Run the database schema given below.

### ✔ Step 5 — Configure Email SMTP  
Update SMTP settings inside:
```
EmailService.java
```

### ✔ Step 6 — Deploy on Apache Tomcat  

### ✔ Step 7 — Run Application  
```
http://localhost:8080/EmailVerificationSystem/
```

## 7️⃣ Database Schema  

```sql
>>>>>>> 50e0d63 (Update readme file)
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

## 8️⃣ Email Configuration (JavaMail)  

Update SMTP settings inside your Email Service class:

```
SMTP_HOST      = "smtp.gmail.com"
SMTP_PORT      = "587"
SENDER_EMAIL   = "your-email@gmail.com"
APP_PASSWORD   = "your-app-password"
```

Use **Gmail App Password** (recommended) for secure SMTP access.

## 🔟 Author  
**Developed by: Aniket Jumde**  
GitHub: https://github.com/aniketjumde  
