package com.api.service;
import org.springframework.stereotype.Service;

import java.util.List;
import com.api.model.Customer;

@Service
public interface CustomerService {

    void deleteEvent(Integer id);
    public Customer saveCustomer(Customer c);
    public Customer getCustomer(Integer id);
    public Customer updateCustomer();
}