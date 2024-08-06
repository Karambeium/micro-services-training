package com.api.controller;

import com.api.model.Customer;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository cr;

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Integer id){
        return cr.getByID(id);
    }

    @GetMapping("")
    public List<Customer> getAllCustomers(){
        return cr.findAll();
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer c){
        return cr.save(c);
    }

    @PostMapping("/byname")
    public List<Customer> getByName(@RequestBody String name)
    {
        return cr.findByName(name);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        Optional<Customer> c = cr.findById(id);
        cr.deleteById(id);
        return "Deleted customer with name :" + c.get().getName();
    }

}

/**
 curl -i -X POST -H 'Content-Type: application/json' -d '{"name": "karam", "email": "kj", "password": "pass"}' localhost:8080/api/customer/addCustomer
 curl -i -X POST -H 'Content-Type: application/json' -d '{"name": "karam"}' localhost:8080/api/customer/getByName
 curl -i -X POST -H 'Content-Type: application/json' -d '{"name": "karam"}' localhost:8080/api/customer/getByName?name=karam
 */