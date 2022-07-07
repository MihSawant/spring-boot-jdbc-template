# spring-data-jdbc-template-custom-prop

This is a project where I have used spring's **JDBC (Java Database Connectivity) Template**
to access the database and perform simple operations like INSERT, UPDATE and FIND.
As we can see that it helps us to write the sql queries in a better way and also in
less lines of code.

Jdbc-Template is a good approach to use in small projects where we do not have to add
any other dependencies, and it works great. Methods like _query()_ and _select()_
are easy to use to select or insert/update/delete data. We need to just add the dependency and 
the Database dependency, so we get the JDBC Driver to access that specific database.
Spring Boot configures the Jdbc-Template.

Now instead of H2 embedded database, I am using mysql database therefore I need to add the 
mysql-connector dependency in the pom.xml which will give the data-source and needed Driver
to connect to it.
Then in application.properties I need to define url of the database, username and the password
so that it can authenticate and provide us to connect to it.
And the most important thing is that we have to load the schema.sql file and generate the table,
so for this we need to specify the property **spring.sql.init.mode=always** so that spring will
only use _schema.sql_ file to create the database.

In this app I have a basic Country model with name and code, which i persist in the database
and then expose the data using a Rest Controller.
