package com.ms.pet.Services.Impl;

import com.ms.pet.Entities.Pet;
import com.ms.pet.Persistence.IPetDAO;
import com.ms.pet.Services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements IPetService {

    @Autowired
    private IPetDAO petDAO;

    @Override
    public Optional<Pet> findById(Long id){
        return petDAO.findById(id);
    }

    @Override
    public List<Pet> findAll(){
        return petDAO.findAll();
    }

    @Override
    public List<Pet> findByCustomer(Long id) {
        return petDAO.findByCustomer(id);
    }

    @Override
    public void save(Pet pet){
        petDAO.save(pet);
    }

    @Override
    public void deleteById(Long id){
        petDAO.deleteById(id);
    }
}
