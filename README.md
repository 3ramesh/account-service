# Account Service

[GitHub Repository](https://github.com/3ramesh/account-service)
## Overview
Account Service manages user accounts and money transfers.
It exposes REST APIs to create accounts, get account details, and transfer funds between accounts.


The service ensures:
- Unique account numbers
- Validation of request data
- Transaction management (rollback on failure)
- Clear success/failure responses


---

## Features
- Create an account with a unique account number
- Get account details by account number
- Transfer money between accounts
- Validation and proper exception handling
- Transaction management with rollback support

---

## Technologies
- Java 21
- Spring Boot 3.4
- Spring Data JPA
- MySQL 8
- MapStruct
- Lombok
- Maven
- Hibernate
- Spring Validation
- Apache Commons

---

## Prerequisites
- Java 21+
- Maven
- MySQL database running locally
- CREATE database account_db

---


## Setup & Run

### 1. Clone the repository
```bash
git clone https://github.com/3ramesh/account-service.git
cd account-service
git checkout master