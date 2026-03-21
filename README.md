# TodoApp

### Application Release
- **Version**: 0.0.1-SNAPSHOT

### Description
A simple Spring Boot application for managing a task list. 
It provides a RESTful API to create, read, update, and delete tasks.
The application uses Spring Data JPA with a PostgreSQL database and includes Swagger/OpenAPI documentation.

### API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/tasks` | Retrieve all tasks. |
| `GET` | `/api/tasks/{id}` | Retrieve a specific task by its ID. |
| `POST` | `/api/tasks` | Create a new task. |
| `PUT` | `/api/tasks/{id}` | Update an existing task. |
| `DELETE` | `/api/tasks/{id}` | Delete a task. |

### Documentation
docker run --name todoapp-db \
-e POSTGRES_DB=todoapp \
-e POSTGRES_USER=postgres \
-e POSTGRES_PASSWORD=postgres \
-p 5432:5432 \
-d postgres:15
- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) 
- (available when the application is running)

