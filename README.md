
## Cinema

Project created with using of SOLID principles, also were applied N-tier architecture layers: layer  DB, layer  DAO, layer  Service, Controllers. <br>
Added authorization and authentication.

Users can have roles roles and make some actions: <br>

## User role: <br>
- Add sessions to shopping cart
- Find session by date
- logout
- Make an order
- View a list of available movies
- View order list
- View the list of cinema halls

## Admin role: <br>
- Add movie session
- Find session by date
- Find user by email
- logout
- View / add movie
- View / add cinema hall

## No role: <br>
- Authorization
- Find session by date
- View a list of available movies
- View the list of cinema halls
- Registration

# Technologies used <br>
**backend:** Java, Hibernate, Tomcat, Spring Core/MVC/Security. <br>
**database:** MySQL<br>

# Start the project: <br>
1.Install JDK [JDK](https://www.oracle.com/java/technologies/javase-downloads.html, "Download JDK") <br>
2.Install Apache Tomcat servlet container [Tomcat](https://tomcat.apache.org/download-90.cgi, "Download Tomcat") <br>
3.Install MySQL Server [MySQL Server](https://dev.mysql.com/downloads/) <br>

4.Connection setup
+ user: "name"
+ password: "password"
+ url: jdbc:mysql://"host name":"port"/"db"
+ Run a project
