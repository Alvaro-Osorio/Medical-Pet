package com.ms.pet.Controllers.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetDTO {

    private Long id;
    private String name;
    private String description;
    private int specieId;
    private int customerId;
}

