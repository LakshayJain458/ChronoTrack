# ⏱️ ChronoTrack — Backend

ChronoTrack is a modular Spring Boot backend for managing task lists and tasks with support for priorities, statuses, and deadlines.  
It is designed for scalability, clean architecture, and easy integration with frontend.

---

## 📌 Project Overview

ChronoTrack provides a robust backend system for:
- Managing task lists and tasks
- Handling task statuses and priorities using enums
- DTOs and mappers to cleanly separate API and entity layers
- Global exception handling
- Service-repository pattern for business logic
- Ready for database integration (H2, PostgreSQL, etc.)

---

## ⚙️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Lombok (optional)**
- **Maven**

---

## 📁 Project Structure

```

TT\_Backend/
├── src/main/java/org/example/tt\_backened/
│    ├── Controller/
│    │    ├── GlobalExceptionHandler
│    │    ├── TaskController
│    │    └── TaskListController
│    ├── DTO/
│    │    ├── ErrorResponseDto
│    │    ├── TaskDto
│    │    └── TaskListDto
│    ├── Entities/
│    │    ├── TaskLists
│    │    ├── TaskPriority
│    │    ├── Tasks
│    │    └── TaskStatus
│    ├── Mappers/
│    │    ├── Impl/
│    │    │    ├── TaskListMapperImpl
│    │    │    └── TaskMapperImpl
│    │    ├── TaskListMapper
│    │    └── TaskMapper
│    ├── Repositories/
│    │    ├── TaskListsRepo
│    │    └── TasksRepo
│    ├── Services/
│    │    ├── Impl/
│    │    │    ├── TaskListServiceImpl
│    │    │    └── TaskServiceImpl
│    │    ├── TaskListService
│    │    └── TaskService
│    └── TtBackenedApplication
├── src/main/resources/
├── docker-compose.yml
├── pom.xml
├── .gitignore
└── README.md

````

---

## 🚀 Getting Started

### Clone the repository
```bash
git clone https://github.com/yourusername/chrono-track-backend.git
cd chrono-track-backend
````

### Build and run the project

```bash
mvn clean install
mvn spring-boot:run
```

---

## 📌 Key Modules

* **Controller:** Handles incoming requests and response formatting.
* **DTO:** Defines data transfer objects for clean API contracts.
* **Entities:** JPA entity definitions for database tables.
* **Mappers:** Convert between entities and DTOs.
* **Repositories:** Data access layer (Spring Data JPA).
* **Services:** Business logic layer (with clear separation of interface and implementation).
* **Exception Handling:** Centralized error management.

---

## ⚡ Future Enhancements

* Frontend.
* Add JWT-based authentication and role-based access.
* Implement search, filters, and pagination.
* Integrate Swagger / OpenAPI docs.
* Real-time updates with WebSockets.

---

## 🙌 Author

Developed with ❤️ by **Lakshay Jain**
<!-- 
Built with guidance from Devtiro's YouTube tutorial: great Resource to follow. 
-->

---

## ✨ License

This project is open source and free to use.
