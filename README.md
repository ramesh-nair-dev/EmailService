# 📧 Email Notification Service

**A lightweight Spring Boot microservice that listens for events and sends emails — simple, reliable, and production-ready.**

---

## ✨ Key Features

* **Event-driven** ⚡: `SendEmailEventConsumer` listens for email events and triggers delivery.
* **Clean data flow** 🧩: `SendEmailEventDTO` carries all necessary fields (recipient, subject, body).
* **Utility-first design** 🛠️: `EmailUtil` centralizes the logic for sending messages via configured SMTP.
* **Minimal footprint** 🌱: Focused service that does one thing well — handle notifications.

---

## ⚡ Quickstart

Clone, build, and run:

```bash
git clone <this-repo>
cd email-service
mvn spring-boot:run
```

Configure your mail server in `application.properties`:

```properties
spring.mail.host=smtp.example.com
spring.mail.port=587
spring.mail.username=your-username
spring.mail.password=your-password
```

---

## 🔍 How It Works

1. **Producer Service** publishes a `SendEmailEvent`.
2. **Consumer** (`SendEmailEventConsumer`) listens and deserializes into `SendEmailEventDTO`.
3. **Utility** (`EmailUtil`) sends the email using SMTP configuration.

---

## 🛠️ Tech Stack

* Java 21, Spring Boot 3.5
* Spring Messaging / Event Consumption
* JavaMail / SMTP integration
* Lombok, Maven

---

## Link 

* [Kakfa](https://faithful-narwhal-cb8.notion.site/Kafka-26437b382b7180b3b125ccdd376f2b7f) – Explained in detail

---

## 👤 Author

**Ramesh Nair**

* Backend Engineer | Java | Spring Boot | System Design Enthusiast
* Focused on building **scalable, maintainable, real-world systems**.
* Passionate about **clean architecture, design patterns, and domain modeling**.

📫 Reach me at: ramesh200212@gmail.com
🌐 GitHub: https://github.com/ramesh-nair-dev

---



