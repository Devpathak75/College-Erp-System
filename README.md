# 🎓 College ERP System

A full-featured **College ERP System** developed using **Java, JSP, Servlets, JDBC, and MySQL**, designed to manage different roles like **Admin, Faculty, and Students** with a secure **OTP-based authentication system**.

This project focuses on **real-world session handling, role-based access control, and clean UI dashboards**, similar to enterprise-level ERP applications.

---

## 🚀 Features

### 🔐 Authentication & Security
- Role-based login: **Admin / Faculty / Student**
- **Email OTP verification** for secure login
- Proper **session management** to avoid role & email mix-up
- Secure logout with session invalidation

### 👨‍🎓 Student Module
- Student login using **Enrollment Number**
- OTP sent to **student’s registered email**
- Student dashboard access after OTP verification

### 👨‍🏫 Faculty Module
- Faculty login using **Email & Password**
- OTP-based authentication
- Faculty dashboard with:
  - Attendance management
  - Assignment upload
  - View uploaded assignments

### 👨‍💼 Admin Module
- Admin login with OTP verification
- Admin dashboard access
- Role-based redirection

---

## 🛠️ Tech Stack

- **Frontend:** JSP, HTML, CSS  
- **Backend:** Java Servlets  
- **Database:** MySQL  
- **Connectivity:** JDBC  
- **Server:** Apache Tomcat  
- **Authentication:** Email OTP System  
- **IDE:** Eclipse  

---

## 🧠 Key Learning Outcomes

- Session lifecycle management in Java web applications
- Preventing session reuse bugs across multiple roles
- OTP-based authentication flow
- Secure role-based access control
- Real-world ERP login architecture
- Clean and maintainable project structure

---

## 📂 Project Structure
