package com.api.controller;

import com.api.model.Customer;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository cr;

    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer ID){
        return cr.getByID(ID);
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return cr.findAll();
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer c){
        return cr.save(c);
    }

    @PostMapping("/getByName")
    public List<Customer> getByName(@RequestParam String name)
    {
        return cr.findByName(name);
    }
}

/**
 curl -i -X POST -H 'Content-Type: application/json' -d '{"name": "karam", "email": "kj", "password": "pass"}' localhost:8080/api/customer/addCustomer
 curl -i -X POST -H 'Content-Type: application/json' -d '{"name": "karam"}' localhost:8080/api/customer/getByName
 curl -i -X POST -H 'Content-Type: application/json' -d '{"name": "karam"}' localhost:8080/api/customer/getByName?name=karam
 */