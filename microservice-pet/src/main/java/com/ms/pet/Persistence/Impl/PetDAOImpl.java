package com.ms.pet.Persistence.Impl;

import com.ms.pet.Entities.Pet;
import com.ms.pet.Persistence.IPetDAO;
import com.ms.pet.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PetDAOImpl implements IPetDAO {

    @Autowired
    private PetRepository petRepository;

    @Override
    public Optional<Pet> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Pet> findAll(){
        return (List<Pet>) petRepository.findAll();
    }

    @Override
    public List<Pet> findByCustomer(Long id) {
        return (List<Pet>) petRepository.findAllByCustomerId(id);
    }

    @Override
    public void save(Pet pet){
        petRepository.save(pet);
    }

    @Override
    public void deleteById(Long id){
        petRepository.deleteById(id);
    }
}
