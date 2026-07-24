# Bank Management System

A RESTful Bank Management System built using Spring Boot, Spring Data JPA, Hibernate, and MySQL. The application allows users to manage bank accounts with CRUD operations and banking functionalities such as deposit and withdrawal.

## Features

- Create Account
- Get Account by ID
- Update Account
- Delete Account
- Deposit Money
- Withdraw Money
- Custom Exception Handling
- Global Exception Handling
- Input Validation
- MySQL Database Integration
- RESTful APIs
- Postman Tested

## Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- Git & GitHub

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/accounts | Create Account |
| GET | /api/accounts/{id} | Get Account |
| PUT | /api/accounts/{id} | Update Account |
| DELETE | /api/accounts/{id} | Delete Account |
| PUT | /api/accounts/{id}/deposit?amount=1000 | Deposit Money |
| PUT | /api/accounts/{id}/withdraw?amount=500 | Withdraw Money |

## Future Improvements

- Authentication & Authorization
- Transaction History
- Fund Transfer
- Swagger API Documentation
- Docker Deployment

## Author

**Thapaswini Eesha Reddy**
