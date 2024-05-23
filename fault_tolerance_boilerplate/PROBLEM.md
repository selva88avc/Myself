# Assignment: Implementing Resiliance4j

## Assignment Task:
You are tasked with creating a Spring Boot application that involves:
#### 1. Developing two microservices, namely ProductService and NotificationService. 
        - The ProductService is responsible for managing product information
        - The NotificationService handles notifications for product updates. 
#### 2. Implement fault tolerance using Resilience4J in the communication between these microservices.

### ProductService:

- Expose an endpoint to retrieve product information by product ID.
- Whenever a product is updated, send a message using rest template.
- Use Resilience4J to make calls to the NotificationService in a resilient manner.

### NotificationService:

- Use Resttemplate
- Whenever a message is received, simulate sending a notification (e.g., print a log statement).
- Use Resilience4J to make calls to the ProductService in a resilient manner.

### Setup:
- Create a new Spring Boot project or an existing one using the latest version of Spring Boot. This is the boilerplate with an existing project.
- Add the necessary dependencies including resilliance4j.
- Create separate packages for controllers, services, models, and configurations.
- Implement Resilience4J for fault tolerance in communication between microservices.
- Include circuit breakers, retries, and fallbacks as needed.
- Make necessary configurations in application.properties file
