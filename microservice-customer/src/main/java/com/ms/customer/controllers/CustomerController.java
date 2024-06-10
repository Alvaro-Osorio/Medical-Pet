package com.ms.customer.controllers;

import com.ms.customer.controllers.DTOs.CustomerDTO;
import com.ms.customer.entities.Customer;
import com.ms.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Customer> customerOptional = customerService.findById(id);

        if (customerOptional.isPresent()){
            Customer customer = customerOptional.get();

            CustomerDTO customerDTO = CustomerDTO.builder()
                    .name(customer.getName())
                    .lastName(customer.getLastName())
                    .address(customer.getAddress())
                    .phone(customer.getPhone())
                    .build();

            return ResponseEntity.ok(customerDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<Customer> customers = customerService.findAll();

        List<CustomerDTO> customersDTO = customers.stream()
                .map(customer -> CustomerDTO.builder()
                        .name(customer.getName())
                        .lastName(customer.getLastName())
                        .address(customer.getAddress())
                        .phone(customer.getPhone())
                        .build())
                .toList();

        return ResponseEntity.ok(customersDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CustomerDTO customerDTO) throws URISyntaxException {
        Customer customer = (Customer.builder()
                .name(customerDTO.getName())
                .lastName(customerDTO.getLastName())
                .address(customerDTO.getAddress())
                .phone(customerDTO.getPhone())
                .build());
        customerService.save(customer);
        return ResponseEntity.created(new URI("/api/customers/save")).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody CustomerDTO customerDTO, @PathVariable Long id){
        Optional<Customer> customerOptional = customerService.findById(id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.setName(customerDTO.getName());
            customer.setLastName(customerDTO.getLastName());
            customer.setAddress(customerDTO.getAddress());
            customer.setPhone(customerDTO.getPhone());
            customerService.save(customer);

            return ResponseEntity.ok("Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id != null){
            customerService.deleteById(id);
            return ResponseEntity.ok("Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getByCustomer/{id}")
    public ResponseEntity<?> getByCustomer(@PathVariable Long idCustomer){

        return ResponseEntity.ok(customerService.findPetsByCustomer(idCustomer));
    }


}
