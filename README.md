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

1.Introduction
  -SCHOLARLY is built to simplify the process of managing teacher and student information, including personal details and academic records. This system aims to automate and streamline various administrative tasks, thereby improving efficiency and accuracy.

  Key Objectives:
  -Ease of Use: Provide an intuitive interface for users, including administrators, teachers, and students.
  -Scalability: Ensure the system can handle a growing number of students, data without compromising performance and additional functions without hinderance.

2.Features
  -Student and Teacher Registration: Add, update and manage teacher and student details.
  -Subject Management: Create and manage subjects.
  -Grade Tracking: Record and update student grades.(not completeted yet)
  -User Roles: Manage different user roles and permissions (Admin, Teacher, Student).

3.Technologies used
  -Backend: Spring Boot, Spring Data JPA, Hibernate
  -Frontend: Thymeleaf, HTML, CSS
  -Database: MySQL
  -Build Tool: Maven

4.Getting Started
Prerequisites:
  -JDK 11 or higher
  -IntelliJ IDEA
  -MySQL
  -Maven
  -Git

5.Usage and workflow explained
... Once the application is running, an account for admin is automatically created with email address and password and some data for database is also initialized. Admin information can be used to login the system. Then admin can create information for teachers, students and subjects. This information will then be saved in database. Then teachers and students can use this information to login.
Admin can management teachers, students and subjects information while teachers can handle information of students and scores. Meanwhile students are only allowed to see the displayed information.


6.Installation
  a.Clone the repository:
    ```bash
    git clone https://github.com/your-username/student-management-system.git
    cd student-management-system
    ```
  b.Configure the database:
    -Update the application.properties file in the src/main/resources directory with your MySQL database details.
      spring.datasource.url=jdbc:mysql://localhost:3306/management_system
      spring.datasource.username=your-username
      spring.datasource.password=your-password
      spring.jpa.hibernate.ddl-auto=update
  c.Build the project:
      mvn clean install
  d.Run the application:
    mvn spring-boot:run
  e.Access the application:
    Open your browser and navigate to http://localhost:8080.

7.Missing aspects
  -Spring security for authorization
  -Web interface is not designed responsively

8.Contact
-For any questions or feedback, please contact at linhchi1152004@gmail.com.
  






