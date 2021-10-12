package com.example.template.services;

import com.example.template.dtos.PersonaRequestDTO;
import com.example.template.dtos.PersonaResponseDTO;

import com.example.template.exceptions.PersonaDontFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonaService {
    PersonaResponseDTO create(PersonaRequestDTO PersonaRequestDTO);
    PersonaResponseDTO getById(long id) throws PersonaDontFoundException;
    List<PersonaResponseDTO> getAll();
    PersonaResponseDTO update(long id, PersonaRequestDTO PersonaRequestDTO) throws PersonaDontFoundException;
    boolean delete(long id) throws PersonaDontFoundException;
}
