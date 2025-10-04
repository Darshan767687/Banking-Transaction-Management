# Banking Transaction Management

A **Java console-based banking application** that demonstrates core concepts of **Object-Oriented Programming (OOP)**, **DAO (Data Access Object) Design Pattern**, and **JDBC** for database connectivity.  
This project allows users to perform basic banking operations like **authentication, deposit, withdraw, balance inquiry**, and handles exceptions gracefully.

---

## 🚀 Features
- 🔑 **User Authentication** (login validation)
- 💰 **Deposit & Withdraw** functionality
- 📊 **Balance Check**
- ⚡ **DAO Pattern Implementation** (separating business logic from database layer)
- 🛠️ **Custom Exception Handling** (`input_mismatch`)
- 🔗 **JDBC Database Connectivity** with MySQL
- 🧩 **Modular Code Structure** with packages (`Authentication`, `Connection`, `DAO`, `DTO`, `Services`)

---

## 🏗️ Project Structure

src/ └── com/saven/ ├── Authentication/Authentication.java ├── connection/Connection_factory.java ├── DAO/BANK_operation.java ├── DAO/BANK_operationimpl.java ├── DTO/Bank_obj.java ├── exception/input_mismatch.java ├── daoDriver.java └── Services/BankingServices.java

---

## 🛠️ Tech Stack
- **Language:** Java (Core + Advanced)
- **Database:** MySQL
- **Tools & Libraries:** JDBC
- **Design Pattern:** DAO

---

## ⚡ How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/Darshan767687/Banking-Transaction-Management.git
   cd Banking-Transaction-Management

2. Setup MySQL database:

Create a database (e.g., bankdb).

Create necessary tables for customers and transactions.



3. Update DB credentials inside Connection_factory.java.


4. Compile and run:

javac -d bin src/**/*.java
java -cp bin daoDriver




---

📚 Learning Outcomes

Understanding of DAO Design Pattern

Hands-on with Java JDBC

Working with custom exceptions

Clean coding practices with layered architecture



---

👤 Author

Darshan B V
GitHub Profile


---

✨ Feel free to fork this repo, raise issues, or suggest improvements!

---
