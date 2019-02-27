package com.lambdaschool.ordersswagger.controllers;

import com.lambdaschool.ordersswagger.models.Agent;
import com.lambdaschool.ordersswagger.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @Timed
@RequestMapping(path = "agents", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgentController {
  @Autowired
  AgentRepository repository;

  @GetMapping("")
  // @Timed(value = "all.agents", longTask = true)
  public List<Agent> all() {
    return repository.findAll();
  }

  @GetMapping("{id}")
  public Agent oneById(@PathVariable Long id) {
    var found = repository.findById(id);
    if (found.isPresent()) {
      return found.get();
    }
    return null;
  }

  @PostMapping("")
  public Agent add(@RequestBody Agent agent) {
    return repository.save(agent);
  }

  @PutMapping("{id}")
  public Agent update(@RequestBody Agent agent, @PathVariable Long id) {
    var found = repository.findById(id);
    if (found.isPresent()) {
      agent.setId(id);
      return repository.save(agent);
    }
    return null;
  }

  @DeleteMapping("{id}")
  public Agent delete(@PathVariable Long id) {
    var found = repository.findById(id);
    if (found.isPresent()) {
      Agent agent = found.get();

      if (
        agent.getOrders().isEmpty() ||
        agent.getCustomers().isEmpty()
      ) {
        return null;
      }

      repository.deleteById(id);
      return agent;
    }
    return null;
  }
}
