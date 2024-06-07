package com.ms.pet.Controllers;

import com.ms.pet.Controllers.DTOs.PetDTO;
import com.ms.pet.Entities.Pet;
import com.ms.pet.Services.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    @Autowired
    private IPetService petService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Pet> petOptional = petService.findById(id);
        if (petOptional.isPresent()){
            Pet pet = petOptional.get();

            PetDTO petDTO = PetDTO.builder()
                    .id(pet.getId())
                    .description(pet.getDescription())
                    .specieId(pet.getSpecieId())
                    .customerId(pet.getCustomerId())
                    .build();

            return ResponseEntity.ok(petDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll(){
        List<Pet> pets = petService.findAll();

        List<PetDTO> petsDTO = pets.stream()
                .map(pet -> PetDTO.builder()
                        .id(pet.getId())
                        .name(pet.getName())
                        .description(pet.getDescription())
                        .specieId(pet.getSpecieId())
                        .customerId(pet.getCustomerId())
                        .build()
                ).toList();
        return ResponseEntity.ok(petsDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PetDTO petDTO) throws URISyntaxException {

        petService.save(Pet.builder()
                .name(petDTO.getName())
                .description(petDTO.getDescription())
                .specieId(petDTO.getSpecieId())
                .customerId(petDTO.getCustomerId())
                .build());
        return ResponseEntity.created(new URI("/api/pets/save")).build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PetDTO petDTO,@PathVariable Long id){

        Optional<Pet> petOptional = petService.findById(id);

        if (petOptional.isPresent()) {
            Pet pet = petOptional.get();
            pet.setName(petDTO.getName());
            pet.setDescription(petDTO.getDescription());
            pet.setSpecieId(petDTO.getSpecieId());
            pet.setCustomerId(petDTO.getCustomerId());
            return ResponseEntity.ok("Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (id != null) {
            petService.deleteById(id);
            return ResponseEntity.ok("Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getByCustomer/{id}")
    public ResponseEntity<?> getByCustomer(@PathVariable Long idCustomer){
        List<Pet> pets = petService.findByCustomer(idCustomer);

        List<PetDTO> petsDTO = pets.stream()
                .map(pet -> PetDTO.builder()
                        .id(pet.getId())
                        .name(pet.getName())
                        .description(pet.getDescription())
                        .specieId(pet.getSpecieId())
                        .customerId(pet.getCustomerId())
                        .build()
                ).toList();
        return ResponseEntity.ok(petsDTO);
    }

}
