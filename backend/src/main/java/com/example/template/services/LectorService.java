package com.example.template.services;

import com.example.template.dtos.LectorRequestDTO;
import com.example.template.dtos.LectorResponseDTO;
import com.example.template.exceptions.LectorDontFoundException;
import com.example.template.model.Lector;
import com.example.template.repositories.LectorRepository;
import com.example.template.services.ILectorService;
import com.example.template.mappers.MapperLector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LectorService implements ILectorService {

    protected LectorRepository LectorRepository;
    protected MapperLector mapperLector;

    @Override
    public LectorResponseDTO create(LectorRequestDTO LectorRequestDTO) {
        LectorResponseDTO LectorResponseDTO;
        Lector Lector;

        Lector = mapperLector.toLector(LectorRequestDTO);
        Lector.setFechaInicioVigencia(LocalDate.now());
        LectorResponseDTO = mapperLector.toLectorResponseDTO(Lector);

        Lector LectorSave = LectorRepository.save(Lector);

        LectorResponseDTO.setLectorId(LectorSave.getLectorId());

        return LectorResponseDTO;
    }

    @Override
    public LectorResponseDTO getById(long id) throws LectorDontFoundException {
        Optional<Lector> optional = LectorRepository.findById(id);
        if (optional.isEmpty()){
            throw new LectorDontFoundException(id);
        }
        Lector Lector = optional.get();

        if (!(Lector.getFechaFinVigencia()==null)){
            throw new LectorDontFoundException(id);
        }

        LectorResponseDTO LectorResponseDTO = mapperLector.toLectorResponseDTO(Lector);

        return LectorResponseDTO;
    }

    @Override
    public List<LectorResponseDTO> getAll() {
        List<Lector> LectorList;
        List<LectorResponseDTO> LectorResponseDTOList = new ArrayList<>();

        LectorList = LectorRepository.findAll();

        for (Lector Lector: LectorList) {
            if (Lector.getFechaFinVigencia()==null) {
                LectorResponseDTO LectorResponseDTO = mapperLector.toLectorResponseDTO(Lector);
                LectorResponseDTOList.add(LectorResponseDTO);
            }
        }
        return LectorResponseDTOList;
    }

    @Override
    public LectorResponseDTO update(long id, LectorRequestDTO LectorRequestDTO) throws LectorDontFoundException {
        Optional<Lector> LectorOptional  = LectorRepository.findById(id);
        if (LectorOptional.isEmpty()){
            throw new LectorDontFoundException(id);
        }
        Lector Lector = LectorOptional.get();
        if (!(Lector.getFechaFinVigencia()==null)){
            throw new LectorDontFoundException(id);
        }

        Lector LectorUpdate = mapperLector.toLector(LectorRequestDTO,id);

        LectorUpdate.setFechaInicioVigencia(Lector.getFechaInicioVigencia());
       LectorUpdate = LectorRepository.save(LectorUpdate);

        LectorResponseDTO LectorResponseDTO = mapperLector.toBaseDeDatosDTO(baseDeDatosUpdate);

        return LectorResponseDTO;
    }

    @Override
    public boolean delete(long id) throws LectorDontFoundException {
        Optional<Lector> LectorOptional  = LectorRepository.findById(id);

        if (LectorOptional.isEmpty()){
            throw new LectorDontFoundException(id);
        }

        Lector Lector = LectorOptional.get();
        Lector.setFechaFinVigencia(LocalDate.now());
        LectorRepository.save(Lector);

        return true;
    }
}
