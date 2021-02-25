
Project created with using of SOLID principles, also were applied N-tier architecture layers: layer  DB, layer  DAO, layer  Service, Controllers.
Added authorization and authentication.

UML diagram whith entity relations.
project_cinema_uml
------------------------------
User with no roles:
Authorization
Find session by date
View a list of available movies
View the list of cinema halls
Registration
------------------------------
User role:
Add sessions to shopping cart
Find session by date
logout
Make an order
View a list of available movies
View order list
View the list of cinema halls
------------------------------
Admin role:
Add movie session
Find session by date
Find user by email
logout
View / add movie
View / add cinema hall
-----------------------------

Technologies used
backend: Java, Hibernate, Tomcat, Spring Core/MVC/Security.
database: MySQL

To start the project:
Install JDK
Install Apache Tomcat
Install MySQL Server
Setup new connection with
user: "name"
password: "password"
url: jdbc:mysql://"your host name":"your port"/"your name db"
Run a project
