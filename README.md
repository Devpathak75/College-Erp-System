# College ERP System

A Java-based web application designed to manage college administrative and academic activities using a structured MVC architecture.

---

## 🚀 Features

- Role-based authentication (Admin & Student)
- Student management system
- Attendance management
- Assignment upload and download
- Secure session handling
- Clean MVC architecture

---

## 🛠️ Technology Stack

- Java (JSP & Servlets)
- JDBC
- MySQL
- Maven
- Apache Tomcat
- Eclipse IDE

---

## 📂 Project Structure

CollegeERPSystem  
│  
├── src/main/java  
│   └── com.collegeerp  
│       ├── controller   → Servlets (Request Handling)  
│       ├── dao          → Database Operations  
│       ├── model        → Entity Classes  
│       └── util         → DB Connection Utility  
│  
├── src/main/webapp  
│   ├── admin            → Admin JSP Pages  
│   ├── student          → Student JSP Pages  
│   └── login.jsp  
│  
├── pom.xml              → Maven Configuration  
└── target               → Build Output  

---

## 🧩 Architecture

This project follows the MVC (Model-View-Controller) design pattern:

- Model: Java Beans & DAO
- View: JSP pages
- Controller: Servlets

---

## ⚙️ Setup Instructions

1. Clone the repository
2. Import as Maven project in Eclipse
3. Configure MySQL database
4. Update DB credentials in `DBConnection.java`
5. Deploy on Apache Tomcat
6. Run the project

---

## 📌 Future Enhancements

- Password encryption
- Email notifications
- REST API integration
- UI improvements

---

## 👨‍💻 Author

Developed as an academic Java Web Application project for learning enterprise-level development.

---

⭐ If you find this project useful, feel free to star the repository!
