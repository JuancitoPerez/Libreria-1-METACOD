package com.example.template.services;

import com.example.template.dtos.AutorRequestDTO;
import com.example.template.dtos.AutorResponseDTO;
import com.example.template.exceptions.AutorDontFoundException;
import com.example.template.model.Autor;
import com.example.template.repositories.AutorRepository;
import com.example.template.services.IAutorService;
import com.example.template.mappers.MapperAutor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AutorService implements IAutorService {

    protected AutorRepository AutorRepository;
    protected MapperAutor mapperAutor;

    @Override
    public AutorResponseDTO create(AutorRequestDTO AutorRequestDTO) {
        AutorResponseDTO AutorResponseDTO;
        Autor Autor;

        Autor = mapperAutor.toAutor(AutorRequestDTO);
        Autor.setFechaInicioVigencia(LocalDate.now());
        AutorResponseDTO = mapperAutor.toAutorResponseDTO(Autor);

        Autor AutorSave = AutorRepository.save(Autor);

        AutorResponseDTO.setAutorId(AutorSave.getAutorId());

        return AutorResponseDTO;
    }

    @Override
    public AutorResponseDTO getById(long id) throws AutorDontFoundException {
        Optional<Autor> optional = AutorRepository.findById(id);
        if (optional.isEmpty()){
            throw new AutorDontFoundException(id);
        }
        Autor Autor = optional.get();

        if (!(Autor.getFechaFinVigencia()==null)){
            throw new AutorDontFoundException(id);
        }

        AutorResponseDTO AutorResponseDTO = mapperAutor.toAutorResponseDTO(Autor);

        return AutorResponseDTO;
    }

    @Override
    public List<AutorResponseDTO> getAll() {
        List<Autor> AutorList;
        List<AutorResponseDTO> AutorResponseDTOList = new ArrayList<>();

        AutorList = AutorRepository.findAll();

        for (Autor Autor: AutorList) {
            if (Autor.getFechaFinVigencia()==null) {
                AutorResponseDTO AutorResponseDTO = mapperAutor.toAutorResponseDTO(Autor);
                AutorResponseDTOList.add(AutorResponseDTO);
            }
        }
        return AutorResponseDTOList;
    }

    @Override
    public AutorResponseDTO update(long id, AutorRequestDTO AutorRequestDTO) throws AutorDontFoundException {
        Optional<Autor> AutorOptional  = AutorRepository.findById(id);
        if (AutorOptional.isEmpty()){
            throw new AutorDontFoundException(id);
        }
        Autor Autor = AutorOptional.get();
        if (!(Autor.getFechaFinVigencia()==null)){
            throw new AutorDontFoundException(id);
        }

        Autor AutorUpdate = mapperAutor.toAutor(AutorRequestDTO,id);

        AutorUpdate.setFechaInicioVigencia(Autor.getFechaInicioVigencia());
       AutorUpdate = AutorRepository.save(AutorUpdate);

        AutorResponseDTO AutorResponseDTO = mapperAutor.toBaseDeDatosDTO(baseDeDatosUpdate);

        return AutorResponseDTO;
    }

    @Override
    public boolean delete(long id) throws AutorDontFoundException {
        Optional<Autor> AutorOptional  = AutorRepository.findById(id);

        if (AutorOptional.isEmpty()){
            throw new AutorDontFoundException(id);
        }

        Autor Autor = AutorOptional.get();
        Autor.setFechaFinVigencia(LocalDate.now());
        AutorRepository.save(Autor);

        return true;
    }
}
