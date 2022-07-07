# spring-data-bean-config-jdbc-temp

This is a project where I have used spring's **JDBC (Java Database Connectivity) Template**
to access the database and perform simple operations like INSERT, UPDATE and FIND.
As we can see that it helps us to write the sql queries in a better way and also in
less lines of code.

Jdbc-Template is a good approach to use in small projects where we do not have to add
any other dependencies, and it works great. Methods like _query()_ and _select()_
are easy to use to select or insert/update/delete data. We need to just add the dependency and 
the Database dependency, so we get the JDBC Driver to access that specific database.

As I am using my custom database in this case MySQL, I add the connector to the pom.xml so that
spring knows it and configures me the specific Driver. Now instead of using the properties file 
for specifying the database details like url, password and username I used the **_@Bean_** approach
to create the bean in Configuration file which returns the Datasource instance of HikariCP datasource
and in that I specify the username, url and password through _@Value_ annotation so that it configures
it from the application.properties file and we do not have to Hard-Code it.
And doing so I do not need to change any of my implementations and Spring will observe and use my configured
datasource for all the data operations.
Usually we need can use this approach when we need to specify some additional details, for that we manually
add the bean and as you know using the _@Bean_ we have more control over creating the bean instance type. And specify
additional details while creating the instance like any ConnectionPool or other settings.

In this app I have a basic Country model with name and code, which i persist in the database
and then expose the data using a Rest Controller.