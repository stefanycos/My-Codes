# Demo project

### Operation
Implementation of a example using events in Spring Boot. <br>
When a Order pass to the next step, a event called changeStatus is generated, notifying all listeners waiting for that event.

### Running application

1. Clone project in GitHub: `http://gitlab.tokiomarine.com.br/arquitetura-sistemas/development/portal/portal.git`
2. Enter in project directory and run `mvn spring-boot:run`
3. Access swagger: `http://localhost:8080/swagger-ui.html#/order-controller`