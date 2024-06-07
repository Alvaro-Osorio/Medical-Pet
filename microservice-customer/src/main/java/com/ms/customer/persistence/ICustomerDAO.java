package com.ms.customer.persistence;

import com.ms.customer.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerDAO {

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    void save(Customer customer);

    void deleteById(Long id);
}
