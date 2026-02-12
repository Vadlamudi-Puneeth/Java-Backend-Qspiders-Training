# Java Backend QSpiders Training

This repository contains Java backend learning projects created during my **QSpiders Training**, focusing on core Java backend technologies such as JDBC, Hibernate, and Unit Testing.

Each folder represents a different module or concept learned over time. The aim is to showcase real working code along with database connectivity and testing fundamentals.

---

## 🗂 Project Structure

```
Java-Backend-Qspiders-Training/
├── basicsofjdbc/             # Basic JDBC programs
├── learnjdbc/                # JDBC CRUD examples
├── hibernatebasics/          # Hibernate setup and basic mapping
├── hibernatecrud/            # Hibernate CRUD operations + JUnit tests
├── junittesting/             # Unit testing with JUnit examples
├── .gitignore
└── README.md
```



---

## 📌 Overview of Each Module

### 📁 basicsofjdbc

Contains fundamental JDBC programs demonstrating:

- Loading the JDBC driver
- Establishing a database connection
- Executing SQL queries
- Processing results using `ResultSet`

Ideal for beginners to understand how plain JDBC works.

---

### 📁 learnjdbc

This folder expands on JDBC by implementing:

✔ Create, Read, Update, Delete (CRUD)  
✔ PreparedStatement usage  
✔ Handling SQLExceptions  
✔ Proper resource closing

This is perfect practice for interacting with databases in a secure and efficient way.

---

### 📁 hibernatebasics

Introduces Hibernate ORM with:

- Configuration setup (`hibernate.cfg.xml`)
- Mappings of Java classes to database tables
- Basic `SessionFactory` usage
- Save / update operations

This module helps understand how Hibernate simplifies database management compared to raw JDBC.

---

### 📁 hibernatecrud

One of the core projects: full **Hibernate CRUD implementation**.

Features:

✨ Create, Read, Update, Delete operations on `Passport` entity  
✨ Configured using Hibernate + MySQL (or any other DB)  
✨ Demonstrates best practices in session & transaction handling  
✨ Uses Maven for dependency management

This module showcases a practical backend application structure.

---

### 📁 junittesting

This folder contains **JUnit test cases** covering:

✔ Unit testing service and DAO layers  
✔ Assertions  
✔ Test lifecycle methods  
✔ Running tests via IDE and Maven

This is essential for building testable, reliable Java applications.

---

## 🚀 How to Run the Projects

> **Prerequisites:**
- Java JDK 8+
- Maven
- MySQL (or other supported DB)
- Git

1. Clone the repository:

   ```bash
   git clone https://github.com/Vadlamudi-Puneeth/Java-Backend-Qspiders-Training.git
   cd Java-Backend-Qspiders-Training
