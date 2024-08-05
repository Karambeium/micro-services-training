package com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    @GetMapping("/getCustomer")
    public String getCustomer(){
        return "This one will return the customer!";
    }
}
