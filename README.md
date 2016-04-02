# Zup App Backend Project

This project aims to build a RESTful API with Java and Web Application to communicate with it.

## Architecture

### App's Backend

The RESTful API is a [Maven](https://maven.apache.org/) project using [Jersey2](https://jersey.java.net/) and [Grizzly2](https://grizzly.java.net/).
All the Application data is stored in [MongoDB](https://www.mongodb.org/).
The tests were done using [JUnit](http://junit.org/junit4/) and the coverage using [JaCoCo](http://eclemma.org/jacoco/).

### App's Frontend

The frontend part is an AngularJS web application using Bootstrap. However, is a very simple application.
It uses [npm](https://www.npmjs.com/) and [bower](http://bower.io/) for package managing and this [boilerplate](https://github.com/angular/angular-seed) for a quick start.

## Dependencies

### App's Backend
* [Maven](https://maven.apache.org/)
- [Jersey2](https://jersey.java.net/)
- [Grizzly2](https://grizzly.java.net/)
- [Jersey Jackson Json](https://github.com/FasterXML/jackson-jaxrs-providers)
- [JUnit](http://junit.org/junit4/)
- [JaCoCo](http://eclemma.org/jacoco/)
* [MongoDB 3.2.1](https://www.mongodb.org/)
- [MongoDB Java Driver](https://docs.mongodb.org/ecosystem/drivers/java/)


### App's Frontend
* [npm](https://www.npmjs.com/)/[bower](http://bower.io/)
 * [AngularJS](https://angularjs.org/)
 * [JQuery](https://jquery.com/)
 * [Bootstrap](http://getbootstrap.com/)

 ## Building and Running

 To run the the code you need to install Java, Maven, MongoDB and npm.

 After that, you can run the code:

Running the database:
    $ mongod

    $ mvn clean compile

    $ mvn exec:java

    $ mvn exec:java@insert

    $ mvn test

    $ npm install

    $ npm start
