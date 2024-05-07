package com.task.vasunamdevfliprinternshiptask.dao;

import com.task.vasunamdevfliprinternshiptask.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
    List<Customer> findByCustomerCity(String city);
}
