Student Registration App 🎓

A Java Web Application built using the MVC architecture (Model-View-Controller) to manage student registrations. This project demonstrates core Java web technologies including Servlets, JSP, JSTL, and JDBC with MySQL.

🚀 Features
Register Student: a form to input student details (Name, Email, Year).
View Students: A dynamic table displaying all registered students from the database.
Data Persistence: Saves data permanently using a MySQL database.
Input Validation: Server-side validation to ensure data integrity.

🛠️ Tech Stack
Language: Java (JDK 11+)
Frontend: JSP (JavaServer Pages), JSTL (Standard Tag Library), HTML/CSS
Backend: Java Servlets
Database: MySQL
Server: Apache Tomcat 9
IDE: IntelliJ IDEA

📋 Prerequisites
Before running the project, ensure you have the following installed:
Java Development Kit (JDK)
Apache Tomcat (Version 9 or 10)
MySQL Server
IntelliJ IDEA (Ultimate or Community with Smart Tomcat plugin)


⚙️ Setup & Installation
1. Database Setup
Run the following SQL commands in your MySQL Workbench or Command Line to set up the database:
code SQL
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    year INT NOT NULL
);
2. Project Configuration
Clone/Open the project in IntelliJ IDEA.
Dependencies: Ensure the following JAR files are in src/main/webapp/WEB-INF/lib/ and added as libraries in IntelliJ:
mysql-connector-j-x.x.x.jar (MySQL JDBC Driver)
jstl-1.2.jar (JSTL Library)
Database Connection:
Open src/java/util/DBConnection.java.
Update the USER and PASSWORD fields to match your local MySQL credentials.
Optional: Use Environment Variables (DB_USER, DB_PASSWORD) for better security.
3. IntelliJ Configuration
Go to Run > Edit Configurations.
Click + and add a Tomcat Server (Local).
In the Deployment tab, add the artifact: StudentRegistrationApp: Web Application: Exploded.
Set the Application Context to / (root) or /student.
▶️ How to Run
Click the green Run (Play) button in IntelliJ.
Wait for the server to start (Look for "Artifact is deployed successfully" in the console).
The browser should open automatically. If not, visit:
http://localhost:8080/ (if context is /)
http://localhost:8080/student (if context is /student)
📂 Project Structure
code
Code
StudentRegistrationApp/
├── src/
│   ├── java/
│   │   ├── dao/          # Data Access Object (Database Logic)
│   │   ├── model/        # Student Class (POJO)
│   │   ├── servlet/      # Controllers (Handle Requests)
│   │   └── util/         # Database Connection Helper
│
├── webapp/
│   ├── WEB-INF/
│   │   ├── lib/          # External JARs (JSTL, MySQL Driver)
│   │   └── web.xml       # Deployment Descriptor
│   ├── index.jsp         # Registration Form
│   └── students.jsp      # List of Students (View)
