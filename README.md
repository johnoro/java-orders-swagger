# java-orders-swagger

# Introduction

This is a basic database scheme with customers, orders, and sales agents.

# Instructions

Create a REST api server to store and read data from the provided SQLite Database called orders.db. The database is adapted from the sample database found at https://www.w3resource.com/sql/sql-table.php. This a continuation of the java-orders-sqlite project. So start with your java-orders-sqlite project and proceed from there.


* This is the new stuff!

  * Add Swagger Documentation to your REST APIs
    * Add custom responses to each of the follow error conditions
    * Add custom Swagger Documentation to each of the follow End Points. The rest of the end points may just have the default documentation.
      - [ ] GET /customers - returns all the customer
      - [ ] GET /customers/custcode/{custcode}
    - [ ] For a stretch goal - add custom responses to the rest of the end points
  - [x] Add flyway data migration
  
    * for this project we will just have the starting migration. The DDL for creating the tables can be found in the file tables.DDL

## OLD STUFF -- All finished.

* Convert to using SQLite
* Add additional end points
  * change end points so they return null when no data is found.
  * change end points so they return data that is deleted or a new copy of updated data
* Expose actuator end points

The table layouts are as follows

* AGENTS
  * AGENTCODE primary key, not null Long
  * AGENTNAME string
  * WORKINGAREA string
  * COMMISSION double
  * PHONE string
  * COUNTRY string

* CUSTOMERS
  * CUSTCODE primary key, not null Long
  * CUSTNAME String, not null
  * CUSTCITY String
  * WORKINGAREA String
  * CUSTCOUNTRY String
  * GRADE String
  * OPENINGAMT double
  * RECEIVEAMT double
  * PAYMENTAMT double
  * OUTSTANDINGAMT double
  * PHONE String
  * AGENTCODE long foreign key (one agent to many customers) not null

* ORDERS
  * ORDNUM primary key, not null Long
  * ORDAMOUNT double
  * ADVANCEAMOUNT double
  * CUSTCODE long foreign key (one customer to many orders) not null
  * AGENTCODE long foreign key (one agent to many orders) not null
  * ORDDESCRIPTION


* Create the entities needed to store this data
* connect to the provided SQLite database orders.db
 
* Create a generic error html page to return when error 404 happens (the rate of this depends on the user following directions).
* Create a different generic error html page to return when error 500 happens (this should be rare).
* Create a different generic error html page to return when an error other than a 404 or 500 happens (what? This should not happen).

* End points should return the data they worked with or nothing if no data was found

Expose the following end points

* GET /customers - returns all the customer
* GET /orders - return all the orders
* GET /agents - return all the agents

* GET /customers/custcode/{custcode}
* GET /orders/ordnum/{ordnum}
* GET /agents/agentcode/{agentcode}

* POST /customers - adds a customer
* POST /orders - adds an order
* POST /agents - adds an agent

* PUT /customers/custocode/{custcode} - updates a customer based on custcode
* PUT /orders/ordnum/{ordnum} - updates an order based on ordnum
* PUT /agents/agentcode/{agentcode} - updates an agent based on ordnum

* DELETE /customers/custcode/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders
* DELETE /orders/ordnum/{ordnum} - deletes an order based off its ordnum
* DELETE agents/agentcode/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)

* /customers/order - Returns all customers with their orders
* /customers/name/{custname} - Returns all orders for a particular customer based on name
* /customers/order/{custcode} - Returns all orders for a particular customer based on custcode
* /agents - Returns all agents with their customers
* /agents/orders - Return a list with the agents name and associated order number and order description
* /customers/{custcode} - Deletes a customer based off of their custcode and deletes all their associated orders
* /agents/{agentcode} - Deletes an agent if they are not assigned to a customer or order (Stretch Goal)

* Expose at least the following the actuator endpoints to help with system mangagement
   * /health
   * /inf
   * /metrics
   
   * Stretch goal - update each of these three actuator endpoints to report your own messages. 
