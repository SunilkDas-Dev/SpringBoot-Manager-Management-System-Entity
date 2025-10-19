🌟 Manager Management System
🧩 Overview

The Manager Management System is a Spring Boot RESTful API project designed to perform complete CRUD operations — Create, Read, Update, and Delete — for managing manager details.
It uses MySQL as the database and APIs are tested and documented using Postman, Swagger, Insomnia, and Hoppscotch for reliable backend performance.

⚙️ Features

➕ Insert Manager Details – Add new manager records to the database
🔍 Get Manager Details – Retrieve manager information
✏️ Update Manager Details – Modify existing manager records
❌ Delete Manager Details – Remove manager records

🗄️ Tech Stack
Category	Technologies
Backend Framework	Spring Boot
Language	Java
Database	MySQL
API Documentation & Testing	Swagger, Postman, Insomnia, Hoppscotch
Build Tool	Maven / Gradle
IDE	Spring Tool Suite (STS) / IntelliJ IDEA / Eclipse

🧠 Learning Outcomes
Implemented CRUD operations in a real-world Spring Boot project
Connected and managed data efficiently using MySQL
Explored API testing and documentation using Postman, Swagger, Insomnia, and Hoppscotch
Gained hands-on experience in building a Manager Management System

Configure application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/manager_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

Test the APIs using:
Swagger UI: http://localhost:8080/swagger-ui/index.html
Postman / Insomnia / Hoppscotch

📚 Example Endpoints
Operation	Method	Endpoint
Create	POST	/saveManager
Read	GET	/getAllManagers
Update	PUT	/updateManager/{id}
Delete	DELETE	/deleteManager/{id}
