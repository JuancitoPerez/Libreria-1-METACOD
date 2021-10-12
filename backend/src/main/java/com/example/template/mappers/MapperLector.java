package com.example.template.mappers;

import com.example.template.dtos.LectorRequestDTO;
import com.example.template.dtos.LectorResponseDTO;
import com.example.template.model.Lector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperLector {

    public Lector toLector(LectorRequestDTO LectorRequestDTO){
        Lector Lector = new Lector();
        Lector.setNroSocio(LectorRequestDTO.getNroSocio());

        return Lector;
    }

    public Lector toLector(LectorRequestDTO LectorRequestDTO, long id){
        Lector Lector = new Lector();
        Lector.setNroSocio(LectorRequestDTO.getNroSocio());

        return Lector;
    }

    public LectorResponseDTO toLectorResponseDTO(Lector Lector){
        LectorResponseDTO LectorResponseDTO = new LectorResponseDTO();
        LectorResponseDTO.setNroSocio(Lector.getNroSocio());

        return LectorResponseDTO;
    }

}
