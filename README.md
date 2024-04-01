# Quiz Application using Spring Boot.

This is a simple Spring Boot project which has endpoints for a Quiz Application. It is a MCQ based quiz with 4 options and has a single right answer.

## Technologies and tools used

    * Spring Boot
    * MySQL
    * Postman

## Required dependencies

    * Spring Data JPA
    * Spring Web
    * MySQL Driver

## Add the below code in application.properties

    ``` 
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/DatabaseName
    spring.datasource.username=root
    spring.datasource.password=yourDatabasePassword
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    ```



