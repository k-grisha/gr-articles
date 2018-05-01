
####Requirements
*JDK 1.8
*Maven 3 

####Package source code
Unpack archive to any folder and move to the new folder
Build package with a command
```
mvn package
```
move to the /target/ folder and run application by command
```
java -jar gr-articles-0.0.1-SNAPSHOT.war
```
try it out [http://localhost:8080/](http://localhost:8080/)


####Tools
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) - REST API specification

[http://localhost:8080/h2-console/](http://localhost:8080/h2-console/) - H2 database console
JDBC URL: jdbc:h2:mem:gr_article
user: sa
pass:

####Feature
*Administration panel for Articles, Authors and Categories
*Functionalities for Add, Delete and Edit all resources
*Functionalities for associate Articles with Category and Author
*Validation of unique Categories names 
*REST API for third party systems
    *get specific Article by ID
    *get paginal Articles list with sorting by fields

