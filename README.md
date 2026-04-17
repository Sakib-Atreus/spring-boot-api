# 🚀 Spring Boot API

A beginner-friendly **Spring Boot REST API** for managing products and orders.  
This project demonstrates clean architecture, modular structure, and basic business logic like inventory handling.

---

## 📌 Features

### 🛍️ Product Module
- Create product
- Get all products
- Get product by ID
- Update product
- Delete product
- Unique product name validation

### 📦 Order Module
- Place order using product ID
- Automatically decrease product quantity
- Prevent ordering when stock is insufficient
- Get all orders
- Order status handling (SUCCESS / FAILED)

---

## 🏗️ Tech Stack

- Java 17+ / Java 21 / Java 25
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Lombok
- Swagger (OpenAPI)

---

## 📁 Project Structure
```
src/main/java/com/test/app/modules/

├── product/
│   ├── dto/
│   ├── entity/
│   ├── mapper/
│   ├── ProductController.java
│   ├── ProductService.java
│   └── ProductRepository.java
│
├── order/
│   ├── dto/
│   ├── entity/
│   ├── mapper/
│   ├── enums/
│   ├── OrderController.java
│   ├── OrderService.java
│   └── OrderRepository.java

---
```
## ⚙️ Setup & Run

### 1. Clone the repository
```bash
git clone https://github.com/sakib-atreus/spring-boot-api.git
cd spring-boot-api
```

### 2. Configure Database

spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=your_username
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update

---

### 3. Run the application

mvn spring-boot:run

App will run on:
http://localhost:8080

---

## 📖 API Documentation (Swagger)

http://localhost:8080/docs

---

## 🔁 Example API Flow

### Create Product
POST /api/products

### Place Order
POST /api/orders

- Checks product availability
- Decreases stock
- Creates order

---

## ⚠️ Business Rules

- Product name must be unique
- Order cannot be placed if stock is insufficient
- Product quantity automatically decreases after order

---

## 🧠 Learning Goals

- Layered architecture
- DTO & Mapper pattern
- Transaction handling
- Inventory logic
- Clean code practices

---

## 🚧 Future Improvements

- Global exception handling
- Validation
- Pagination
- JWT auth
- Docker support
- Testing

---

## 👨‍💻 Author

Sakib Dev
