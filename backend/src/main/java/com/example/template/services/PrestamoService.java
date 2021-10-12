package com.example.template.services;

import com.example.template.dtos.PrestamoRequestDTO;
import com.example.template.dtos.PrestamoResponseDTO;
import com.example.template.exceptions.PrestamoDontFoundException;
import com.example.template.model.Prestamo;
import com.example.template.repositories.PrestamoRepository;
import com.example.template.services.IPrestamoService;
import com.example.template.mappers.MapperPrestamo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PrestamoService implements IPrestamoService {

    protected PrestamoRepository PrestamoRepository;
    protected MapperPrestamo mapperPrestamo;

    @Override
    public PrestamoResponseDTO create(PrestamoRequestDTO PrestamoRequestDTO) {
        PrestamoResponseDTO PrestamoResponseDTO;
        Prestamo Prestamo;

        Prestamo = mapperPrestamo.toPrestamo(PrestamoRequestDTO);
        Prestamo.setFechaInicioVigencia(LocalDate.now());
        PrestamoResponseDTO = mapperPrestamo.toPrestamoResponseDTO(Prestamo);

        Prestamo PrestamoSave = PrestamoRepository.save(Prestamo);

        PrestamoResponseDTO.setPrestamoId(PrestamoSave.getPrestamoId());

        return PrestamoResponseDTO;
    }

    @Override
    public PrestamoResponseDTO getById(long id) throws PrestamoDontFoundException {
        Optional<Prestamo> optional = PrestamoRepository.findById(id);
        if (optional.isEmpty()){
            throw new PrestamoDontFoundException(id);
        }
        Prestamo Prestamo = optional.get();

        if (!(Prestamo.getFechaFinVigencia()==null)){
            throw new PrestamoDontFoundException(id);
        }

        PrestamoResponseDTO PrestamoResponseDTO = mapperPrestamo.toPrestamoResponseDTO(Prestamo);

        return PrestamoResponseDTO;
    }

    @Override
    public List<PrestamoResponseDTO> getAll() {
        List<Prestamo> PrestamoList;
        List<PrestamoResponseDTO> PrestamoResponseDTOList = new ArrayList<>();

        PrestamoList = PrestamoRepository.findAll();

        for (Prestamo Prestamo: PrestamoList) {
            if (Prestamo.getFechaFinVigencia()==null) {
                PrestamoResponseDTO PrestamoResponseDTO = mapperPrestamo.toPrestamoResponseDTO(Prestamo);
                PrestamoResponseDTOList.add(PrestamoResponseDTO);
            }
        }
        return PrestamoResponseDTOList;
    }

    @Override
    public PrestamoResponseDTO update(long id, PrestamoRequestDTO PrestamoRequestDTO) throws PrestamoDontFoundException {
        Optional<Prestamo> PrestamoOptional  = PrestamoRepository.findById(id);
        if (PrestamoOptional.isEmpty()){
            throw new PrestamoDontFoundException(id);
        }
        Prestamo Prestamo = PrestamoOptional.get();
        if (!(Prestamo.getFechaFinVigencia()==null)){
            throw new PrestamoDontFoundException(id);
        }

        Prestamo PrestamoUpdate = mapperPrestamo.toPrestamo(PrestamoRequestDTO,id);

        PrestamoUpdate.setFechaInicioVigencia(Prestamo.getFechaInicioVigencia());
       PrestamoUpdate = PrestamoRepository.save(PrestamoUpdate);

        PrestamoResponseDTO PrestamoResponseDTO = mapperPrestamo.toBaseDeDatosDTO(baseDeDatosUpdate);

        return PrestamoResponseDTO;
    }

    @Override
    public boolean delete(long id) throws PrestamoDontFoundException {
        Optional<Prestamo> PrestamoOptional  = PrestamoRepository.findById(id);

        if (PrestamoOptional.isEmpty()){
            throw new PrestamoDontFoundException(id);
        }

        Prestamo Prestamo = PrestamoOptional.get();
        Prestamo.setFechaFinVigencia(LocalDate.now());
        PrestamoRepository.save(Prestamo);

        return true;
    }
}
