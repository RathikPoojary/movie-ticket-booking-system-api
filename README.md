
# 🎟️ Movie Ticket Booking System API

A Spring Boot REST API for managing movie tickets, multiplexes, shows, and bookings. Designed for educational, interview, and production-ready use with best practices in Java, Spring Boot, and MySQL.

---

## 🚀 Features

- 🔐 User authentication with role-based access (Admin/User)
- 🎬 Movie and showtime management
- 🏢 Multiplex and screen support
- 📅 Book movie tickets by date and show
- 📊 Swagger UI for API testing

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security + JWT
- MySQL
  - Maven

---

## 📂 Project Structure

```
movie-ticket-booking-system-api/
├── src/
│ └── main/
│ ├── java/
│ │ └── com/example/com.example.movieticketbookingsystem/
│ │ ├── config/
│ │ ├── controller/
│ │ ├── dto/
│ │ ├── entity/
│ │ ├── enums/
│ │ ├── exception/
│ │ ├── mapper/
│ │ ├── repository/
│ │ ├── security/
│ │ ├── service/
│ │ ├── utility/
│ │ └── MovieTicketBookingSystemApiApplication.java
│ └── resources/
├── test/
├── .env.example
├── .gitignore
├── pom.xml
└── README.md   
```

---

## 🧪 Getting Started

### Prerequisites

- Java 17
- MySQL 8+
- Maven

### Clone & Run

```bash
git clone https://github.com/RathikPoojary/movie-ticket-booking-system-api.git
cd movie-ticket-booking-system-api
```

Update `application.properties` with your DB credentials:

```properties
spring.datasource.username=root
spring.datasource.password=root
```

Then build and run:

```bash
mvn clean install
mvn spring-boot:run
```

Access Swagger at:  
👉 `http://localhost:8080/swagger-ui/index.html`

---

## 🧾 API Endpoints

### 👤 User Management
- `POST /register` — Register a new user
- `PUT /users/{email}` — Update user details by email
- `DELETE /users/{email}` — Soft delete a user by email

### 🎭 Theater Management
- `POST /theaters?email={email}` — Add a theater (requires `THEATER_OWNER` role)
- `GET /theaters/{theaterId}` — Get theater details
- `PUT /theaters/{theaterId}` — Update theater details

### 🖥️ Screen Management
- `POST /theaters/{theaterId}/screens` — Add a screen to a theater
- `GET /theaters/{theaterId}/screens/{screenId}` — Get screen details

### ⏰ Show Management
- `POST /theaters/{theaterId}/screens/{screenId}/shows?movieId={movieId}&startTime={startTime}` — Add a show (`THEATER_OWNER` only)

### 🎬 Movie Management
- `GET /movies/{movieId}` — Get movie details

### 📝 Feedback System
- `POST /movies/{movieId}/feedbacks` — Add feedback (requires `USER` role)

### 🔐 Authentication
- `POST /login` — Login and get JWT
- `POST /refresh` — Refresh JWT token

---

## ✅ Future Enhancements

- 🎫 Seat selection and booking
- 📧 Email confirmation after registration
- 🧾 PDF ticket generation
- 🖥️ React/Angular frontend integration

---

## 👨‍💻 Author

**Rathik Ram Poojary**  
[GitHub](https://github.com/RathikPoojary) • [LinkedIn](https://linkedin.com/in/rathik-ram-poojary-082130234)
