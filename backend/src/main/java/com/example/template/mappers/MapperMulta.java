package com.example.template.mappers;

import com.example.template.dtos.MultaRequestDTO;
import com.example.template.dtos.MultaResponseDTO;
import com.example.template.model.Multa;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperMulta {

    public Multa toMulta(MultaRequestDTO MultaRequestDTO){
        Multa Multa = new Multa();
        Multa.setFechaInicio(MultaRequestDTO.getFechaInicio());
        Multa.setFechaFin(MultaRequestDTO.getFechaFin());

        return Multa;
    }

    public Multa toMulta(MultaRequestDTO MultaRequestDTO, long id){
        Multa Multa = new Multa();
        Multa.setFechaInicio(MultaRequestDTO.getFechaInicio());
        Multa.setFechaFin(MultaRequestDTO.getFechaFin());

        return Multa;
    }

    public MultaResponseDTO toMultaResponseDTO(Multa Multa){
        MultaResponseDTO MultaResponseDTO = new MultaResponseDTO();
        MultaResponseDTO.setFechaInicio(Multa.getFechaInicio());
        MultaResponseDTO.setFechaFin(Multa.getFechaFin());

        return MultaResponseDTO;
    }

}
