# java-orders-swagger

# Introduction

This is a basic database scheme with customers, orders, and sales agents.

# Instructions

Create a REST api server to store and read data from the provided SQLite Database called orders.db. The database is adapted from the sample database found at https://www.w3resource.com/sql/sql-table.php. This a continuation of the java-orders-sqlite project. So start with your java-orders-sqlite project and proceed from there.


* This is the new stuff!

  * Add Swagger Documentation to your REST APIs
    * Add custom responses to each of the follow error conditions
    * Add custom Swagger Documentation to each of the follow End Points. The rest of the end points may just have the default documentation.
      - [x] GET /customers - returns all the customer
      - [ ] GET /customers/{id}
    - [ ] For a stretch goal - add custom responses to the rest of the end points
  - [x] Add flyway data migration (and an additional one for some seed data as well)
  
    * for this project we will just have the starting migration. The DDL for creating the tables can be found in the file tables.DDL

###### OLD STUFF is all finished (and removed from this README; see [the old task list here](https://github.com/johnoro/java-orders-sqllite/pull/1)).
