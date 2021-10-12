package com.example.template.mappers;

import com.example.template.dtos.PersonaRequestDTO;
import com.example.template.dtos.PersonaResponseDTO;
import com.example.template.model.Persona;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperPersona {

    public Persona toPersona(PersonaRequestDTO PersonaRequestDTO){
        Persona Persona = new Persona();
        Persona.setNombre(PersonaRequestDTO.getNombre());
        Persona.setApellido(PersonaRequestDTO.getApellido());
        Persona.setFechaNacimiento(PersonaRequestDTO.getFechaNacimiento());
        Persona.setNacionalidad(PersonaRequestDTO.getNacionalidad());

        return Persona;
    }

    public Persona toPersona(PersonaRequestDTO PersonaRequestDTO, long id){
        Persona Persona = new Persona();
        Persona.setNombre(PersonaRequestDTO.getNombre());
        Persona.setApellido(PersonaRequestDTO.getApellido());
        Persona.setFechaNacimiento(PersonaRequestDTO.getFechaNacimiento());
        Persona.setNacionalidad(PersonaRequestDTO.getNacionalidad());

        return Persona;
    }

    public PersonaResponseDTO toPersonaResponseDTO(Persona Persona){
        PersonaResponseDTO PersonaResponseDTO = new PersonaResponseDTO();
        PersonaResponseDTO.setNombre(Persona.getNombre());
        PersonaResponseDTO.setApellido(Persona.getApellido());
        PersonaResponseDTO.setFechaNacimiento(Persona.getFechaNacimiento());
        PersonaResponseDTO.setNacionalidad(Persona.getNacionalidad());

        return PersonaResponseDTO;
    }

}
