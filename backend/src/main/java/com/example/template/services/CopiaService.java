package com.example.template.services;

import com.example.template.dtos.CopiaRequestDTO;
import com.example.template.dtos.CopiaResponseDTO;
import com.example.template.exceptions.CopiaDontFoundException;
import com.example.template.model.Copia;
import com.example.template.repositories.CopiaRepository;
import com.example.template.services.ICopiaService;
import com.example.template.mappers.MapperCopia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CopiaService implements ICopiaService {

    protected CopiaRepository CopiaRepository;
    protected MapperCopia mapperCopia;

    @Override
    public CopiaResponseDTO create(CopiaRequestDTO CopiaRequestDTO) {
        CopiaResponseDTO CopiaResponseDTO;
        Copia Copia;

        Copia = mapperCopia.toCopia(CopiaRequestDTO);
        Copia.setFechaInicioVigencia(LocalDate.now());
        CopiaResponseDTO = mapperCopia.toCopiaResponseDTO(Copia);

        Copia CopiaSave = CopiaRepository.save(Copia);

        CopiaResponseDTO.setCopiaId(CopiaSave.getCopiaId());

        return CopiaResponseDTO;
    }

    @Override
    public CopiaResponseDTO getById(long id) throws CopiaDontFoundException {
        Optional<Copia> optional = CopiaRepository.findById(id);
        if (optional.isEmpty()){
            throw new CopiaDontFoundException(id);
        }
        Copia Copia = optional.get();

        if (!(Copia.getFechaFinVigencia()==null)){
            throw new CopiaDontFoundException(id);
        }

        CopiaResponseDTO CopiaResponseDTO = mapperCopia.toCopiaResponseDTO(Copia);

        return CopiaResponseDTO;
    }

    @Override
    public List<CopiaResponseDTO> getAll() {
        List<Copia> CopiaList;
        List<CopiaResponseDTO> CopiaResponseDTOList = new ArrayList<>();

        CopiaList = CopiaRepository.findAll();

        for (Copia Copia: CopiaList) {
            if (Copia.getFechaFinVigencia()==null) {
                CopiaResponseDTO CopiaResponseDTO = mapperCopia.toCopiaResponseDTO(Copia);
                CopiaResponseDTOList.add(CopiaResponseDTO);
            }
        }
        return CopiaResponseDTOList;
    }

    @Override
    public CopiaResponseDTO update(long id, CopiaRequestDTO CopiaRequestDTO) throws CopiaDontFoundException {
        Optional<Copia> CopiaOptional  = CopiaRepository.findById(id);
        if (CopiaOptional.isEmpty()){
            throw new CopiaDontFoundException(id);
        }
        Copia Copia = CopiaOptional.get();
        if (!(Copia.getFechaFinVigencia()==null)){
            throw new CopiaDontFoundException(id);
        }

        Copia CopiaUpdate = mapperCopia.toCopia(CopiaRequestDTO,id);

        CopiaUpdate.setFechaInicioVigencia(Copia.getFechaInicioVigencia());
       CopiaUpdate = CopiaRepository.save(CopiaUpdate);

        CopiaResponseDTO CopiaResponseDTO = mapperCopia.toBaseDeDatosDTO(baseDeDatosUpdate);

        return CopiaResponseDTO;
    }

    @Override
    public boolean delete(long id) throws CopiaDontFoundException {
        Optional<Copia> CopiaOptional  = CopiaRepository.findById(id);

        if (CopiaOptional.isEmpty()){
            throw new CopiaDontFoundException(id);
        }

        Copia Copia = CopiaOptional.get();
        Copia.setFechaFinVigencia(LocalDate.now());
        CopiaRepository.save(Copia);

        return true;
    }
}
