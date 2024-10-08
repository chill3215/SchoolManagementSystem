# SCHOLARLY - SCHOOL MANAGEMENT SYSTEM



This project is a web application designed to manage teachers and students' information effeciently. Developed using Spring Boot, it leverages the power of modern web technologies to provide a robust, scalable, and easy-to-use platform for educational institutions.
#### --web interface design is not completely finished yet--

## A.Table of Contents
1. Introduction
2. Features
3. Technologies used
4. Getting started
5. Usage and workflow explained
6. Installation
7. Missing aspects
8. Contact


## B.Detailed information

1. Introduction


  SCHOLARLY is built to simplify the process of managing teacher and student information, including personal details and academic records. This system aims to automate and streamline various administrative tasks,   thereby improving efficiency and accuracy.

  

  Key Objectives:

  
  - Ease of Use: Provide an intuitive interface for users, including administrators, teachers, and students.
  - Scalability: Ensure the system can handle a growing number of students, data without compromising performance and additional functions without hinderance.

2. Features
  - Student and Teacher Registration: Add, update and manage teacher and student details.
  - Subject Management: Create and manage subjects.
  - Grade Tracking: Record and update student grades.(not completeted yet)
  - User Roles: Manage different user roles and permissions (Admin, Teacher, Student).
  - Error message for user: The input data is validated and returns a error message for user to let them know where the problems orginate along with an instruction.

3. Technologies used
  - Backend: Spring Boot, Spring Data JPA, Hibernate
  - Frontend: Thymeleaf, HTML, CSS
  - Database: MySQL
  - Build Tool: Maven

4. Getting Started

  - JDK 11 or higher
  - IntelliJ IDEA
  - MySQL
  - Maven
  - Git

5. Usage and workflow explained
- Once the application is running, an account for admin is automatically created with email address and password and some data for database is also initialized. Admin information can be used to login the system. Then admin can create information for teachers, students (password for accounts will be generated randomly) and subjects. This information will then be saved in database. Then teachers and students can use this information (get from the admin) to login.
Admin can management teachers, students and subjects information while teachers can handle information of students and scores. Meanwhile students are only allowed to see the displayed information.


6. Installation
- Clone the repository:
    ```bash
    git clone https://github.com/chill3215/SchoolManagementSystem
    cd SchoolManagementSystem
    ```
- Configure the database:
    + Create a database in your DBMS
      ```mysql
      create database management_system
      ```
    + Update the application.properties file in the src/main/resources directory with your MySQL database details.
      ```java
      spring.datasource.url=jdbc:mysql://localhost:3306/management_system
      spring.datasource.username=your-username
      spring.datasource.password=your-password
      spring.jpa.hibernate.ddl-auto=update
      ```
- Build the project:
    ```bash
      mvn clean install
    ```
- Run the application:
    ```bash
    mvn spring-boot:run
    ```
- Access the application:
    + Open your browser and navigate to http://localhost:8080.

- Use the username and password of admin in the database to log in

7. Missing aspects
  - Spring security for authorization
  - Web interface is not designed responsively

8. Contact
- For any questions or feedback, please contact at linhchi1152004@gmail.com.
  






