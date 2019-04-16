package com.lambdaschool.ordersswagger.repositories;

import com.lambdaschool.ordersswagger.models.Customer;

public interface CustomerRepository extends Repository<Customer> {
  Customer findByName(String name);
}
