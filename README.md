# E-Commerce Application

## Overview

This project is a RESTful E-Commerce backend application developed using **Java Spring Boot**. It provides secure user authentication, product management, shopping cart functionality, checkout, and order management through REST APIs. The application follows a layered architecture and uses JWT-based authentication to secure protected endpoints.

---

## 🚀 Features

### User Module
- User Registration
- User Login with JWT Authentication
- Secure Password Encryption using BCrypt
- Role-Based Authorization
- View User Profile

### Product Module
- Add Product
- View All Products
- Search Products
- View Product Details
- Update Product
- Delete Product

### Cart Module
- Add Product to Cart
- View Cart
- Update Product Quantity
- Remove Product from Cart
- Calculate Cart Total

### Checkout Module
- Shipping Address Management
- Payment Method Selection
- Place Order

### Order Module
- Create Orders
- View Order History
- View Order Details

### Admin Module
- Admin Login
- Product Management
- Inventory Management
- Order Management

---

## 🛠 Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST APIs

---

## 📂 Project Structure

```
src
├── controller
├── service
│   └── impl
├── repository
├── entity
├── dto
├── config
├── security
├── exception
└── util
```

---

## 🏗 Architecture

```
Client
   │
REST Controller
   │
Service Layer
   │
Repository Layer
   │
MySQL Database
```

---

## 🔐 Security

- JWT Authentication
- Spring Security
- BCrypt Password Encryption
- Stateless Session Management
- Role-Based Access Control (User/Admin)

---

## 📡 REST API Modules

- Authentication APIs
- Product APIs
- Cart APIs
- Checkout APIs
- Order APIs
- Admin APIs

---

## ⚙️ Prerequisites

- Java 17 or later
- Maven
- MySQL
- IntelliJ IDEA / Eclipse

---

## ▶️ Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/ecommerce-backend.git
   ```

2. Configure the MySQL database in `application.properties`.

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the application at:
   ```
   http://localhost:8080
   ```

---

## 🔮 Future Enhancements

- Product Categories
- Wishlist
- Product Reviews & Ratings
- Payment Gateway Integration
- Email Notifications
- Swagger/OpenAPI Documentation
- Docker Support
- Unit & Integration Testing

---
## UMLdiagram
<img width="1536" height="1024" alt="UMLdiagram" src="https://github.com/user-attachments/assets/4dce24f4-1d2f-40f4-884c-04c368ab836d" />


## 👨‍💻 Author

**Varun Pratap**  
B.E. Computer Science Engineering  
Java Developer
