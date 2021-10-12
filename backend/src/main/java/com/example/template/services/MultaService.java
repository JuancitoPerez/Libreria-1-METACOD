package com.example.template.services;

import com.example.template.dtos.MultaRequestDTO;
import com.example.template.dtos.MultaResponseDTO;
import com.example.template.exceptions.MultaDontFoundException;
import com.example.template.model.Multa;
import com.example.template.repositories.MultaRepository;
import com.example.template.services.IMultaService;
import com.example.template.mappers.MapperMulta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MultaService implements IMultaService {

    protected MultaRepository MultaRepository;
    protected MapperMulta mapperMulta;

    @Override
    public MultaResponseDTO create(MultaRequestDTO MultaRequestDTO) {
        MultaResponseDTO MultaResponseDTO;
        Multa Multa;

        Multa = mapperMulta.toMulta(MultaRequestDTO);
        Multa.setFechaInicioVigencia(LocalDate.now());
        MultaResponseDTO = mapperMulta.toMultaResponseDTO(Multa);

        Multa MultaSave = MultaRepository.save(Multa);

        MultaResponseDTO.setMultaId(MultaSave.getMultaId());

        return MultaResponseDTO;
    }

    @Override
    public MultaResponseDTO getById(long id) throws MultaDontFoundException {
        Optional<Multa> optional = MultaRepository.findById(id);
        if (optional.isEmpty()){
            throw new MultaDontFoundException(id);
        }
        Multa Multa = optional.get();

        if (!(Multa.getFechaFinVigencia()==null)){
            throw new MultaDontFoundException(id);
        }

        MultaResponseDTO MultaResponseDTO = mapperMulta.toMultaResponseDTO(Multa);

        return MultaResponseDTO;
    }

    @Override
    public List<MultaResponseDTO> getAll() {
        List<Multa> MultaList;
        List<MultaResponseDTO> MultaResponseDTOList = new ArrayList<>();

        MultaList = MultaRepository.findAll();

        for (Multa Multa: MultaList) {
            if (Multa.getFechaFinVigencia()==null) {
                MultaResponseDTO MultaResponseDTO = mapperMulta.toMultaResponseDTO(Multa);
                MultaResponseDTOList.add(MultaResponseDTO);
            }
        }
        return MultaResponseDTOList;
    }

    @Override
    public MultaResponseDTO update(long id, MultaRequestDTO MultaRequestDTO) throws MultaDontFoundException {
        Optional<Multa> MultaOptional  = MultaRepository.findById(id);
        if (MultaOptional.isEmpty()){
            throw new MultaDontFoundException(id);
        }
        Multa Multa = MultaOptional.get();
        if (!(Multa.getFechaFinVigencia()==null)){
            throw new MultaDontFoundException(id);
        }

        Multa MultaUpdate = mapperMulta.toMulta(MultaRequestDTO,id);

        MultaUpdate.setFechaInicioVigencia(Multa.getFechaInicioVigencia());
       MultaUpdate = MultaRepository.save(MultaUpdate);

        MultaResponseDTO MultaResponseDTO = mapperMulta.toBaseDeDatosDTO(baseDeDatosUpdate);

        return MultaResponseDTO;
    }

    @Override
    public boolean delete(long id) throws MultaDontFoundException {
        Optional<Multa> MultaOptional  = MultaRepository.findById(id);

        if (MultaOptional.isEmpty()){
            throw new MultaDontFoundException(id);
        }

        Multa Multa = MultaOptional.get();
        Multa.setFechaFinVigencia(LocalDate.now());
        MultaRepository.save(Multa);

        return true;
    }
}
