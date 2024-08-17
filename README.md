# Welcome to the Highway Hub Microservices Application! 🚗🛣️
This project is a microservice-based backend application for a Highway Ticket Management System, designed to streamline ticket issuance, vehicle registration, user management, and payment processing without relying on external payment gateways.

## Technology Stack
### Core Technologies
✅ Java | Spring Boot | MySQL | Hibernate | Spring Cloud | Spring Cloud Gateway | Eureka | Spring Cloud Config Server

### Testing Tools
✅ Postman

### Key Features:
- Service Registry and Discovery: Utilizes Eureka for dynamic registration and discovery of microservices, enabling seamless communication.
- Centralized Configuration Management: Implements Spring Cloud Config Server to manage configurations centrally, allowing updates without redeployment.
- API Gateway: Spring Cloud Gateway serves as a single-entry point for routing client requests to the appropriate microservices.
- Ticket Management: Manages the complete lifecycle of highway tickets, including creation, status updates, and information retrieval.
- Vehicle Operations: Handles vehicle registration, updates, and retrieval of detailed information.
- User Management: Manages user and owner profiles, covering registration, updates, and credential verification.
- Internal Payment Processing: Facilitates secure payments within the system, validating payment details and updating ticket statuses upon successful payment.


### How to Run:
   
1. **Service Setup:**
   - Clone the repository
   ```bash
   git clone https://github.com/bethmij/Hirly-AI.git
   ```
   - Start the Eureka Server, Config Server, and individual microservices in sequence.
   
2. **Configuration:**
   - Use the Spring Cloud Config Server for centralized management of service configurations.
   
3. **Run API Gateway:**
   - Start the Spring Cloud Gateway to route client requests to the appropriate microservices.

4. **Testing:**
   - Use the included Postman collection to test all API endpoints and validate functionality.



