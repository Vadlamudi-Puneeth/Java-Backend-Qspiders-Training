# Java Backend Development - Project Portfolio

Welcome to the comprehensive repository of Java Backend training projects. This workspace contains a collection of 42 modular projects covering JDBC, Hibernate ORM, Spring Framework, Spring Boot, and specialized case studies.

## 📁 Project Directory Overview

The projects are categorized by technology stack and conceptual complexity.

### 🔌 1. JDBC Foundations
*Basics of Database Connectivity using Java.*

| Sl. No | Project Name | Description | Key Tech / Concepts |
|---|---|---|---|
| 1 | [basicsofjdbc](./basicsofjdbc) | Introductory JDBC operations. | MySQL, Statement, ResultSet |
| 2 | [learnjdbc](./learnjdbc) | Advanced JDBC concepts and CRUD operations. | PreparedStatement, Batch Processing |

---

### ❄️ 2. Hibernate & JPA Core
*Object-Relational Mapping (ORM) and Persistence.*

| Sl. No | Project Name | Description | Key Tech / Concepts |
|---|---|---|---|
| 1 | [hibernatebasics](./hibernatebasics) | Core Hibernate setup and basic CRUD. | Configuration, SessionFactory, Entity |
| 2 | [firstlevelcaching](./firstlevelcaching) | Demonstration of Hibernate First-Level Cache. | Session Cache, Performance |
| 3 | [secondlevelcaching](./secondlevelcaching) | Setting up and testing Distributed Caching. | EhCache, Region Factory |
| 4 | [fintechhibernateJPA](./fintechhibernateJPA) | Financial domain entity management. | JPA Annotations, Banking Logic |

---

### 🗺️ 3. JPA Mapping & Relationships
*Implementing Database Relationships using JPA/Hibernate.*

| Sl. No | Project Name | Description | Relationship Type |
|---|---|---|---|
| 1 | [onetoonemapping](./onetoonemapping) | One-to-One Unidirectional mapping. | `@OneToOne` |
| 2 | [onetoonebidirectionalmapping](./onetoonebidirectionalmapping) | One-to-One Bidirectional mapping. | `mappedBy` attribute |
| 3 | [onetomanymapping](./onetomanymapping) | One-to-Many Unidirectional mapping. | `@OneToMany`, `@JoinColumn` |
| 4 | [onetomanybidirectionalmapping](./onetomanybidirectionalmapping) | One-to-Many Bidirectional mapping. | Parent-Child relationship |
| 5 | [manytoonemapping](./manytoonemapping) | Many-to-One mapping implementation. | Many entities to One parent |
| 6 | [manytomanymappinguni](./manytomanymappinguni) | Many-to-Many Unidirectional mapping. | `@JoinTable` |
| 7 | [manytomanymappingbidirectional](./manytomanymappingbidirectional) | Many-to-Many Bidirectional mapping. | Shared Junction Table |

---

### 🍃 4. Spring Framework
*Core Spring, Dependency Injection, and MVC.*

| Sl. No | Project Name | Description | Config Mode |
|---|---|---|---|
| 1 | [springbasicsxmlconfig](./springbasicsxmlconfig) | Legacy Spring configuration using XML. | applicationContext.xml |
| 2 | [springbasicsannotation](./springbasicsannotation) | Modern Spring config using Java Annotations. | `@Configuration`, `@Bean`, `@Component` |
| 3 | [spring_hibernate](./spring_hibernate) | Integration of Spring with Hibernate. | LocalSessionFactoryBean |
| 4 | [springmvc](./springmvc) | Traditional Spring MVC Web structure. | DispatcherServlet, Controllers |
| 5 | [springmvcboot](./springmvcboot) | Transitioning MVC to Spring Boot. | Auto-Configuration |

---

### � 5. Spring Boot & Microservices
*Modern Java Development with Spring Boot.*

| Sl. No | Project Name | Description | Key Features |
|---|---|---|---|
| 1 | [basicsofspringboot](./basicsofspringboot) | Core Spring Boot application setup. | Starters, Auto-Config |
| 2 | [product_category](./product_category) | Product management with Category relationships. | Spring Data JPA, H2/MySQL |
| 3 | [product_controller](./product_controller) | REST API development for Product entities. | `@RestController`, `@RequestMapping` |
| 4 | [feb26EmployeeManagementSystem](./feb26EmployeeManagementSystem) | End-to-end Employee Management (EMS). | CRUD, Exceptions, DTOs |

---

### 🧪 6. Testing & Mocking
*Unit testing and verification practices.*

| Sl. No | Project Name | Description | Frameworks |
|---|---|---|---|
| 1 | [junittesting](./junittesting) | Standard Unit testing for Java classes. | JUnit 5, Assertions |
| 2 | [mockitopractise](./mockitopractise) | Advanced Mocking with Hibernate integration. | Mockito, `@Mock`, `@InjectMocks` |
| 3 | [mockitowithouthibernate](./mockitowithouthibernate) | Pure Mockito logic testing. | Behavior Verification |

---

### 📚 7. Case Studies & Assignments
*Daily tasks and complex system designs.*

| Sl. No | Folder Name | Topic / Focus | Key Concepts |
|---|---|---|---|
| 1 | [feb10Assignment](./feb10Assignment) | Hibernate CRUD Practice | Session methods |
| 2 | [feb11Assignment](./feb11Assignment) | HQL / Criteria API | Complex Queries |
| 3 | [feb12Assignment](./feb12Assignment) | JPA Repo Basics | Repository Pattern |
| 4 | [feb13AssignmentMockito](./feb13AssignmentMockito) | Service Layer Mocking | Unit Testing Services |
| 5 | [feb13AssignmentOneToOne](./feb13AssignmentOneToOne) | Personal Records (Aadhar/Hostel) | 1:1 Mapping |
| 6 | [feb13Assignmentallinone](./feb13Assignmentallinone) | Education Portal (Course/Instructor) | Mixed Mappings |
| 7 | [feb14casestudy1](./feb14casestudy1) | E-commerce Order Management | Complex Entities |
| 8 | [feb14casestudy2](./feb14casestudy2) | Hospital Appointment System | Service Orchestration |
| 9 | [feb14casestudy3](./feb14casestudy3) | University Management System | Multi-level Mapping |
| 10 | [feb16Assignment](./feb16Assignment) | Social Media Posting (Posts/Comments) | 1:M Mapping |
| 11 | [feb21CRMassignment](./feb21CRMassignment) | Customer Relationship Management | Full CRUD Logic |
| 12 | [springcasestudy1](./springcasestudy1) | Payment Gateway Logic | Spring DI, Abstraction |
| 13 | [springcasestudy2](./springcasestudy2) | Food Delivery App Notifications | Observer Pattern |
| 14 | [springcasestudy3](./springcasestudy3) | Banking Loan Validation System | Strategy Pattern |
| 15 | [hospitalmanagementsystemERP](./hospitalmanagementsystemERP) | Large Scale Hospital ERP | Complete Architecture |

---

## 🛠️ Getting Started
1. **Clone the repository.**
2. **Import into Eclipse IDE:** `File > Import > General > Existing Projects into Workspace`.
3. **Configure Database:** Update the `persistence.xml` or `application.properties` with your MySQL credentials.
4. **Run Projects:** Use `Run As > Spring Boot App` or `Run As > Java Application`.

## 📜 Key Technologies Used
- **Backend:** Java 17+, Spring Boot, Spring MVC
- **Data:** Hibernate 6.x, Spring Data JPA, MySQL
- **Testing:** JUnit 5, Mockito
- **Build:** Maven


