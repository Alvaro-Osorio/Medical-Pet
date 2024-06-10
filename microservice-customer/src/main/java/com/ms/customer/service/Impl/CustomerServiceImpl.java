package com.ms.customer.service.Impl;

import com.ms.customer.client.PetClient;
import com.ms.customer.controllers.DTOs.CustomerDTO;
import com.ms.customer.controllers.DTOs.PetDTO;
import com.ms.customer.entities.Customer;
import com.ms.customer.http.response.PetByCustomerResponse;
import com.ms.customer.persistence.ICustomerDAO;
import com.ms.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDAO customerDAO;

    @Autowired
    private PetClient petClient;

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

    @Override
    public PetByCustomerResponse findPetsByCustomer(Long idCustomer) {

        Optional<Customer> customerOptional = customerDAO.findById(idCustomer);

        if (customerOptional.isPresent()){
            Customer customer = customerOptional.get();
            List<PetDTO> petDTOList = petClient.findAllPetByCustomer(idCustomer);

            return PetByCustomerResponse.builder()
                    .customerName(customer.getName())
                    .customerLastName(customer.getLastName())
                    .petsDTOList(petDTOList)
                    .build();
        }
        return null;
    }
}
