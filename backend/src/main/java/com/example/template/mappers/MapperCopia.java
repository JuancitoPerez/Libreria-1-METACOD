package com.example.template.mappers;

import com.example.template.dtos.CopiaRequestDTO;
import com.example.template.dtos.CopiaResponseDTO;
import com.example.template.model.Copia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperCopia {

    public Copia toCopia(CopiaRequestDTO CopiaRequestDTO){
        Copia Copia = new Copia();
        Copia.setEstado(CopiaRequestDTO.getEstado());

        return Copia;
    }

    public Copia toCopia(CopiaRequestDTO CopiaRequestDTO, long id){
        Copia Copia = new Copia();
        Copia.setEstado(CopiaRequestDTO.getEstado());

        return Copia;
    }

    public CopiaResponseDTO toCopiaResponseDTO(Copia Copia){
        CopiaResponseDTO CopiaResponseDTO = new CopiaResponseDTO();
        CopiaResponseDTO.setEstado(Copia.getEstado());

        return CopiaResponseDTO;
    }

}
