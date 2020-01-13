# Demo project

### Operation
Implementation of an example using events in Spring Boot.
When an Order pass to the next step, an event called changeStatus is generated, notifying all listeners waiting for that event.

### Running application
Clone project in GitHub
Enter in project directory and run mvn spring-boot:run
Access swagger: http://localhost:8080/swagger-ui.html#/order-controller
