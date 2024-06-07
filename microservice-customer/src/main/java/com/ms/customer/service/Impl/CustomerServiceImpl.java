package com.ms.customer.service.Impl;

import com.ms.customer.entities.Customer;
import com.ms.customer.persistence.ICustomerDAO;
import com.ms.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDAO customerDAO;

    @Override
    public Optional<Customer> findById(Long id){
        return customerDAO.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerDAO.deleteById(id);
    }
}
