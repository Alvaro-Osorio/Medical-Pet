package com.ms.pet.Persistence;


import com.ms.pet.Entities.Pet;

import java.util.List;
import java.util.Optional;

public interface IPetDAO {

    Optional<Pet> findById(Long id);

    List<Pet> findAll();

    List<Pet> findByCustomer(Long id);

    void save(Pet pet);

    void deleteById(Long id);
}
