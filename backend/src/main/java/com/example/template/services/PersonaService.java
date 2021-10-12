package com.example.template.services;

import com.example.template.dtos.PersonaRequestDTO;
import com.example.template.dtos.PersonaResponseDTO;
import com.example.template.exceptions.PersonaDontFoundException;
import com.example.template.model.Persona;
import com.example.template.repositories.PersonaRepository;
import com.example.template.services.IPersonaService;
import com.example.template.mappers.MapperPersona;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonaService implements IPersonaService {

    protected PersonaRepository PersonaRepository;
    protected MapperPersona mapperPersona;

    @Override
    public PersonaResponseDTO create(PersonaRequestDTO PersonaRequestDTO) {
        PersonaResponseDTO PersonaResponseDTO;
        Persona Persona;

        Persona = mapperPersona.toPersona(PersonaRequestDTO);
        Persona.setFechaInicioVigencia(LocalDate.now());
        PersonaResponseDTO = mapperPersona.toPersonaResponseDTO(Persona);

        Persona PersonaSave = PersonaRepository.save(Persona);

        PersonaResponseDTO.setPersonaId(PersonaSave.getPersonaId());

        return PersonaResponseDTO;
    }

    @Override
    public PersonaResponseDTO getById(long id) throws PersonaDontFoundException {
        Optional<Persona> optional = PersonaRepository.findById(id);
        if (optional.isEmpty()){
            throw new PersonaDontFoundException(id);
        }
        Persona Persona = optional.get();

        if (!(Persona.getFechaFinVigencia()==null)){
            throw new PersonaDontFoundException(id);
        }

        PersonaResponseDTO PersonaResponseDTO = mapperPersona.toPersonaResponseDTO(Persona);

        return PersonaResponseDTO;
    }

    @Override
    public List<PersonaResponseDTO> getAll() {
        List<Persona> PersonaList;
        List<PersonaResponseDTO> PersonaResponseDTOList = new ArrayList<>();

        PersonaList = PersonaRepository.findAll();

        for (Persona Persona: PersonaList) {
            if (Persona.getFechaFinVigencia()==null) {
                PersonaResponseDTO PersonaResponseDTO = mapperPersona.toPersonaResponseDTO(Persona);
                PersonaResponseDTOList.add(PersonaResponseDTO);
            }
        }
        return PersonaResponseDTOList;
    }

    @Override
    public PersonaResponseDTO update(long id, PersonaRequestDTO PersonaRequestDTO) throws PersonaDontFoundException {
        Optional<Persona> PersonaOptional  = PersonaRepository.findById(id);
        if (PersonaOptional.isEmpty()){
            throw new PersonaDontFoundException(id);
        }
        Persona Persona = PersonaOptional.get();
        if (!(Persona.getFechaFinVigencia()==null)){
            throw new PersonaDontFoundException(id);
        }

        Persona PersonaUpdate = mapperPersona.toPersona(PersonaRequestDTO,id);

        PersonaUpdate.setFechaInicioVigencia(Persona.getFechaInicioVigencia());
       PersonaUpdate = PersonaRepository.save(PersonaUpdate);

        PersonaResponseDTO PersonaResponseDTO = mapperPersona.toBaseDeDatosDTO(baseDeDatosUpdate);

        return PersonaResponseDTO;
    }

    @Override
    public boolean delete(long id) throws PersonaDontFoundException {
        Optional<Persona> PersonaOptional  = PersonaRepository.findById(id);

        if (PersonaOptional.isEmpty()){
            throw new PersonaDontFoundException(id);
        }

        Persona Persona = PersonaOptional.get();
        Persona.setFechaFinVigencia(LocalDate.now());
        PersonaRepository.save(Persona);

        return true;
    }
}
