# Spring Boot Admin and Appointment API

![Screenshot 2025-06-22 192150](https://github.com/user-attachments/assets/ca661997-1933-4add-8e05-52b15a1e8f8e)


## About

A simple Spring Boot application managing **Admins** and their **Appointments** with REST APIs.

Features:
- CRUD operations for Admins
- CRUD operations for Appointments linked to Admins
- Uses JPA entity relationships
- Sample data seeded on startup

## Technologies

- Java 17+  
- Spring Boot 3.x  
- Spring Data JPA / Hibernate  
- H2 or your preferred database  
- Maven or Gradle  

## API Endpoints

### Admins
- `POST /admin/save` - Create admin  
- `GET /admin/read/{adminID}` - Get admin by ID  
- `DELETE /admin/delete/{adminID}` - Delete admin  
- `GET /admin/all` - List all admins  

### Appointments
- `POST /appointment/save` - Create appointment  
- `GET /appointment/read/{appointmentID}` - Get appointment by ID  
- `DELETE /appointment/delete/{appointmentID}` - Delete appointment  
- `GET /appointment/all` - List all appointments  

## How to Run

1. Clone the repository  
2. Configure your database connection in `application.properties`  
3. Run the app (`mvn spring-boot:run`)  
4. Test endpoints using Postman or browser  

