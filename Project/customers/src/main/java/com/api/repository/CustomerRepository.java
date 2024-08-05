package com.api.repository;
import java.util.*;
import com.api.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer getByID(int ID);
    List<Customer> findByName(String name);
}