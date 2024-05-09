# TO-DO List Management Application - Spring Boot Microservices

## Table of Contents
* [Objectives](#objectives)
* [App Description](#app-description)
* [Technologies Used](#technologies-used)
* [Microservices Practices Used](#microservices-practices-deployed)
* [Acknowledgements](#acknowledgements)

## Objectives

**Microservices** is the modern architectural design pattern that enables improved separation of responsibilities among various application components, faster deployment, plug & play release management, stronger security, improved monitoring, rapid debugging and many other features. While implementation of restful services is an important aspect of Microservices development, the real benefit comes from how independently the components are designed and how diligently those are deployed in production environment.

There are several development and deployment principles that need to be followed while deploying microservices in live environment. We miss out some or many of them often in real projects that inhibits us from reaping the full benefits of the architecture. This simple application has been developed and deployed using many of the key microservices practices so as to **act as a ready reference and reminders to architects** who would use this architecture in their organisations to resolve business problems.

## App Description

This is a simple web-based **Todo List management** app which allows already registered users to login to the app and then add/ update/ delete Todos with each having target date of completion and status fields.

## Technologies Used

This is application has been developed using Angular for the web front-end and Java Spring Boot and JPA framework at the backend along with H2 in-memory database.

## Microservices Practices Deployed

The following microservices deployment components have been used in this application. Any architect, aiming to deploy a working microservices architecture in their organisation, should consider these components as part of their deployment roadmap.

The application has been deployed on AWS Cloud (2 nos. of EC2 instances) as well as on local machine. The application functionalities including the various deployment components can be demonstrated on request.

![Todo App MS Architecture](assets/img/Todo-Architecture.png)

### Todo Service

This is the only and main restful microservice that manages the CRUD operations related to Todo List management. It uses JPA to connect to H2 in-memory DB to store and retrieve Todo data.

#### Usage

    Deploy: java -jar todo-microservices-0.0.1-SNAPSHOT.jar --spring.profiles.active=default --spring.h2.console.settings.web-allow-others=true

    API Prefix: http://<IP Address/Domain Name>:8000

    Get Todos: "/todo-services/get-all-todos/user/{username}/todos"

    Get One Todo: "/todo-services/get-todo/user/{username}/todo/{todo_id}

    Create Todo: "/todo-services/add-todo/user/{username}/todo"

    Update a Todo: "/todo-services/update-todo/user/{username}/todo/{todo_id}"

    Delete a Todo: "/todo-services/delete-todo/user/{username}/todo/{todo_id}"


### Discovery Services

Netflix Eureka Naming Server is used as discovery service for the Microservices. The Todo Service and API Gateway register with Naming Server during initialisation.

#### Usage

    Deploy: java -jar naming-server-0.0.1-SNAPSHOT.jar --spring.profiles.active=default

    View: http://<IP Address/Domain Name>:8761

### API Gateway

### Config Server

### Monitoring Service

### Tracing & Logging Service

## Acknowledgements