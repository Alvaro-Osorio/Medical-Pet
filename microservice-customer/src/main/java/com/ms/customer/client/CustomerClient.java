package com.ms.customer.client;

import com.ms.customer.controllers.DTOs.PetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-pet", url = "localhost:8090/api/pet")
public interface CustomerClient {

    @GetMapping("/getByCustomer/{id}")
    List<PetDTO> findAllPetByCustomer(@PathVariable Long id);
}
