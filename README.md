# 📧 Email Verification & Login System (MVC + Hibernate + JSP + Servlets)

A complete, production-grade **User Authentication System** built using  
**Java Servlets, JSP, Hibernate ORM, JDBC, and Apache Tomcat**, featuring:

✔ User Registration with **Email Verification**  
✔ Secure Login with **BCrypt Password Hashing**  
✔ Forgot & Reset Password  
✔ Account Locking on repeated failed logins  
✔ MVC Architecture + Design Patterns  
✔ Token-based security flows  
✔ Session & Input Security  

---

# 🚀 Features

### 🔐 **Authentication & Security**
- User Registration with Email Verification
- User Login with BCrypt password hashing
- Forgot Password & Reset Password using email-token
- Login Attempt Tracking (locks account after 5 failed attempts)
- Role-based access (optional extension)
- Input validation & sanitization
- CSRF Token protection
- Security Headers added:
  - XSS-Protection  
  - X-Frame-Options  
  - Content-Type-Options  

---

# 🧱 Architecture

### ✔ **MVC Architecture**
- **Model:** Hibernate Entities (User, PasswordReset, EmailVerification, LoginAttempt)
- **View:** JSP + JSTL
- **Controller:** Servlets (LoginServlet, RegisterServlet, VerifyServlet, etc.)

### ✔ **Design Patterns Used**
#### 🟦 **Singleton Pattern**
Used in `HibernateUtil.java`  
Ensures a single `SessionFactory` instance.

```java
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
