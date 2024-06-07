package com.ms.pet.Repository;

import com.ms.pet.Entities.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> findAllByCustomerId(Long id);

}
