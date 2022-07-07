# spring-data-jdbc-template

This is a project where I have used spring's **JDBC (Java Database Connectivity) Template**
to access the database and perform simple operations like INSERT, UPDATE and FIND.
As we can see that it helps us to write the sql queries in a better way and also in
less lines of code.

Jdbc-Template is a good approach to use in small projects where we do not have to add
any other dependencies, and it works great. Methods like _query()_ and _select()_
are easy to use to select or insert/update/delete data. We need to just add the dependency and 
the Database dependency, so we get the JDBC Driver to access that specific database.
Spring Boot configures the Jdbc-Template, as you can see there is no **Bean**
defined for it and when we add the.H2 dependency then it automatically adds the Jdbc-Template
instance for it.

In this app I have a basic Country model with name and code, which i persist in the database
and then expose the data using a Rest Controller.