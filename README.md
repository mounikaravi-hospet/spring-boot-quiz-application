# Quiz Application using Spring Boot.

* This is a simple Spring Boot project which has endpoints for a Quiz Application. 
* It is a MCQ based quiz with 4 options and has a single right answer.
* The questions table is in JSON format in Questions.json file.


## Technologies and tools used

    * Spring Boot
    * MySQL
    * Postman

## Required dependencies

    * Spring Data JPA
    * Spring Web
    * MySQL Driver

## Add the below code in application.properties

    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/DatabaseName
    spring.datasource.username=root
    spring.datasource.password=yourDatabasePassword
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

## Sample endpoints

    | Get All Questions | GET | http://localhost:8080/question/allQuestions |
    | Get Questions By Category | GET | http://localhost:8080/question/category/java|
    | Add New Question | POST | http://localhost:8080/question/add |
    | Delete A Question | DELETE | http://localhost:8080/question/delete/2 |
    | Create New Quiz | POST | http://localhost:8080/quiz/create?category=java&numQ=5&title=JQuiz |
    | Get New Quiz | GET | http://localhost:8080/quiz/get/1|
    | Submit Quis and Get Score | POST | http://localhost:8080/quiz/submit/1|





