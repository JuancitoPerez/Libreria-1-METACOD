package com.example.template.services;

import com.example.template.dtos.LibroRequestDTO;
import com.example.template.dtos.LibroResponseDTO;
import com.example.template.exceptions.LibroDontFoundException;
import com.example.template.model.Libro;
import com.example.template.repositories.LibroRepository;
import com.example.template.services.ILibroService;
import com.example.template.mappers.MapperLibro;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LibroService implements ILibroService {

    protected LibroRepository LibroRepository;
    protected MapperLibro mapperLibro;

    @Override
    public LibroResponseDTO create(LibroRequestDTO LibroRequestDTO) {
        LibroResponseDTO LibroResponseDTO;
        Libro Libro;

        Libro = mapperLibro.toLibro(LibroRequestDTO);
        Libro.setFechaInicioVigencia(LocalDate.now());
        LibroResponseDTO = mapperLibro.toLibroResponseDTO(Libro);

        Libro LibroSave = LibroRepository.save(Libro);

        LibroResponseDTO.setLibroId(LibroSave.getLibroId());

        return LibroResponseDTO;
    }

    @Override
    public LibroResponseDTO getById(long id) throws LibroDontFoundException {
        Optional<Libro> optional = LibroRepository.findById(id);
        if (optional.isEmpty()){
            throw new LibroDontFoundException(id);
        }
        Libro Libro = optional.get();

        if (!(Libro.getFechaFinVigencia()==null)){
            throw new LibroDontFoundException(id);
        }

        LibroResponseDTO LibroResponseDTO = mapperLibro.toLibroResponseDTO(Libro);

        return LibroResponseDTO;
    }

    @Override
    public List<LibroResponseDTO> getAll() {
        List<Libro> LibroList;
        List<LibroResponseDTO> LibroResponseDTOList = new ArrayList<>();

        LibroList = LibroRepository.findAll();

        for (Libro Libro: LibroList) {
            if (Libro.getFechaFinVigencia()==null) {
                LibroResponseDTO LibroResponseDTO = mapperLibro.toLibroResponseDTO(Libro);
                LibroResponseDTOList.add(LibroResponseDTO);
            }
        }
        return LibroResponseDTOList;
    }

    @Override
    public LibroResponseDTO update(long id, LibroRequestDTO LibroRequestDTO) throws LibroDontFoundException {
        Optional<Libro> LibroOptional  = LibroRepository.findById(id);
        if (LibroOptional.isEmpty()){
            throw new LibroDontFoundException(id);
        }
        Libro Libro = LibroOptional.get();
        if (!(Libro.getFechaFinVigencia()==null)){
            throw new LibroDontFoundException(id);
        }

        Libro LibroUpdate = mapperLibro.toLibro(LibroRequestDTO,id);

        LibroUpdate.setFechaInicioVigencia(Libro.getFechaInicioVigencia());
       LibroUpdate = LibroRepository.save(LibroUpdate);

        LibroResponseDTO LibroResponseDTO = mapperLibro.toBaseDeDatosDTO(baseDeDatosUpdate);

        return LibroResponseDTO;
    }

    @Override
    public boolean delete(long id) throws LibroDontFoundException {
        Optional<Libro> LibroOptional  = LibroRepository.findById(id);

        if (LibroOptional.isEmpty()){
            throw new LibroDontFoundException(id);
        }

        Libro Libro = LibroOptional.get();
        Libro.setFechaFinVigencia(LocalDate.now());
        LibroRepository.save(Libro);

        return true;
    }
}
