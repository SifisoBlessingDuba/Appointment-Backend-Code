# Spring Boot Car and Customer API
![Screenshot 2025-06-22 192150](https://github.com/user-attachments/assets/7aaeb034-86dd-4cf8-a274-6ef185fba78a)



## About

A basic Spring Boot app managing **Customers** and their **Cars** with REST APIs.

Features:
- CRUD for Customers
- CRUD for Cars linked to Customers
- Uses JPA entity relationships
- Sample data seeded on startup

## Tech Used

- Java 17+
- Spring Boot 3.x
- Spring Data JPA / Hibernate
- H2 or other database
- Maven or Gradle

## API Endpoints

### Customers
- `POST /Customer/save` - Create customer
- `POST /Customer/update` - Update customer
- `DELETE /Customer/deleteCustomer/{ID}` - Delete customer
- `GET /Customer/readCustomer/{ID}` - Get customer by ID
- `GET /Customer/allCustomers` - Get all customers

### Cars
- `POST /Car/add` - Create car
- `POST /Car/update` - Update car
- `DELETE /Car/deleteCar/{carId}` - Delete car
- `GET /Car/readCar/{carId}` - Get car by ID
- `GET /Car/allCars` - Get all cars

## Sample Data

- Customer: Sifiso Duba, sifiso@example.com, 0712345678, Cape Town  
- Car: Toyota Corolla, White, linked to above customer

## How to Run

1. Clone repo  
2. Configure DB in `application.properties`  
3. Run the app (`mvn spring-boot:run`)  
4. Use Postman or browser to test endpoints

