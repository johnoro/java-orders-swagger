package com.lambdaschool.ordersswagger.controllers;

import com.lambdaschool.ordersswagger.models.Customer;
import com.lambdaschool.ordersswagger.models.Order;
import com.lambdaschool.ordersswagger.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "customers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
  @Autowired
  CustomerRepository repository;

  // comes with orders
  @GetMapping("")
  public List<Customer> all() {
    return repository.findAll();
  }

  @GetMapping("{id}")
  public Customer oneById(@PathVariable Long id) {
    var found = repository.findById(id);
    if (found.isPresent()) {
      return found.get();
    }
    return null;
  }

  @GetMapping("name/{name}/orders")
  public Set<Order> ordersByName(@PathVariable String name) {
    name = name.substring(0, 1).toUpperCase()
      + name.substring(1).toLowerCase();
    var customer = repository.findByName(name);

    if (customer == null) {
        return null;
    }

    return customer.getOrders();
  }

  @GetMapping("id/{id}/orders")
  public Set<Order> ordersById(@PathVariable Long id) {
    var customer = repository.findById(id);
    if (customer.isPresent()) {
      return customer.get().getOrders();
    }
    return null;
  }

  @PostMapping("")
  public Customer add(@RequestBody Customer customer) {
    return repository.save(customer);
  }

  @PutMapping("{id}")
  public Customer update(@RequestBody Customer customer, @PathVariable Long id) {
    var found = repository.findById(id);
    if (found.isPresent()) {
      customer.setId(id);
      return repository.save(customer);
    }
    return null;
  }

  @DeleteMapping("{id}")
  public Customer delete(@PathVariable Long id) {
    var found = repository.findById(id);
    if (found.isPresent()) {
      repository.deleteById(id);
      return found.get();
    }
    return null;
  }
}
