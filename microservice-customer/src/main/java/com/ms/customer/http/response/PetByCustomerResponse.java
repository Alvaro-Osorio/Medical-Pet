package com.ms.customer.http.response;

import com.ms.customer.controllers.DTOs.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetByCustomerResponse {

    private String customerName;
    private String customerLastName;
    private List<PetDTO> petsDTOList;

}
