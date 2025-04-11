# 🧳 Travel Holiday Booking System (Microservice Architecture)

This is a scalable, backend-first travel booking system built using **Java Spring Boot microservices**. The goal of this project is to revisit backend fundamentals while experimenting with clean architecture, modular service design, and containerization.

Each feature of the application — such as user management, booking, and payments — is developed as an **independent microservice**, allowing for separation of concerns, better maintainability, and potential scalability in a real-world deployment.

> 🐳 I'm also using **Docker** to containerize each service individually so that they can be developed, tested, and deployed in isolation — just like you'd find in modern cloud-native environments.

This project is a practical playground for learning and demonstrating:
- Microservice communication and autonomy
- Stateless architecture principles
- Real-world API design
- Secure authentication using JWT
- Environment-independent service execution with Docker

---

> 🧠 **Note from Developer**  
> I’m currently rebuilding this project from the ground up to refresh and strengthen my backend development skills post my Master's in AI.  
> The goal is to revisit the fundamentals, apply modern best practices, and experiment with real-world backend architecture, containerization, and microservices — one service at a time.

## 🚀 Project Structure

| Service         | Description                         | Status     |
|----------------|-------------------------------------|------------|
| `user-service` | Handles user registration, login, JWT auth, forgot/reset password | ✅ Complete |
| `booking-service` | Manages user bookings (coming soon) | ⏳ In Progress |
| `payment-service` | Simulates payments & receipts       | ⏳ Planned |

---

## 🧰 Tech Stack

- **Java 17**, Spring Boot 3.x
- Spring Data JPA, Spring Security
- **JWT** based authentication
- **MySQL** database
- REST APIs with Postman
- Docker support (coming soon)

---

## 🧪 How to Run

Each service is a standalone Spring Boot app.

```bash
cd user-service
mvn spring-boot:run
