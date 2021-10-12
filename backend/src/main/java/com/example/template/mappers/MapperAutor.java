package com.example.template.mappers;

import com.example.template.dtos.AutorRequestDTO;
import com.example.template.dtos.AutorResponseDTO;
import com.example.template.model.Autor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperAutor {

    public Autor toAutor(AutorRequestDTO AutorRequestDTO){
        Autor Autor = new Autor();
        Autor.setGeneros(AutorRequestDTO.getGeneros());

        return Autor;
    }

    public Autor toAutor(AutorRequestDTO AutorRequestDTO, long id){
        Autor Autor = new Autor();
        Autor.setGeneros(AutorRequestDTO.getGeneros());

        return Autor;
    }

    public AutorResponseDTO toAutorResponseDTO(Autor Autor){
        AutorResponseDTO AutorResponseDTO = new AutorResponseDTO();
        AutorResponseDTO.setGeneros(Autor.getGeneros());

        return AutorResponseDTO;
    }

}
