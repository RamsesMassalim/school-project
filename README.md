<ol>
<li>
School project
This project is a simple Java Spring Boot application to store, add and delete users.
</li>

<li>
Functionality And Approach Taken:
This project uses Postgresql and consists of database named “school” which has only one table named: “users”.  The user table consist of following columns: 1)id 2)userName 3)firstName 4)lastName 5)dateOfBirth 6)password.
MyBatis is used to communicate with database. In java project the database structure is present in “entity” folder.
BookStore  supports following functionality:
<ol>
<li>Addition of user: “/users”: It adds new user.
<li>Get user by Id: It gets user for the id.  The end point for this function is:”/users/{id}”. Here id is the path variable.</li>
<li>Get all users: It gets all users that are registered. The url for this function is: “/users”.</li>
<li>Delete user: The end point is “/users/{id}”. Here the id is path variable.</li>
<li>Get user by userName and password: The end point is “/auth?userName=userName&password=password”. It has two request param-userName and password.</li>
</ol>
</li>

<li>
Tools/Framework
<ol>
<li>Postgresql: Postgresql is a open-source relational database management system.</li>
<li>MyBatis: MyBatis is a Java persistence framework that couples objects with stored procedures or SQL statements using an XML descriptor or annotations.</li>
<li>Lombok: Project Lombok is a java library that automatically plugs into editor and build tools, spicing up java. Getter, Setters, Construcutors can be created with annotation without writing the code with the help of Lombok.</li>
<li>ModelMapper: ModelMapper is a simple, intelligent, object mapping tool. It is used to map the object in this project.</li>
<li>Liquibase: Liquibase is an open-source database-independent library for tracking, managing and applying database schema changes.</li>
</ol>
</li>

<li>
Steps To Run The Application
<ol>
<li>This project uses Lombok. So, if you do not have Lombok plugins inserted into your IDE, please install it into your IDD.</li>
<li>Install Postgresql in your laptop if you do not have one.</li>
<li>In your Postgresql workbench make a database named: school </li>
<li>Now in your IDE, open the application.properties file, change the spring datasource url, username and password.</li>
<li>Now you can run your application. The table “users” will be automatically created in “school”. By default, it runs in port:8080.</li>
<li>Once you have set up your database, you can also run the unit tests.</li>
</ol>
</li>
</ol>
