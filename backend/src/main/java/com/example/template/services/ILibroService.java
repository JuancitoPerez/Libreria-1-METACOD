package com.example.template.services;

import com.example.template.dtos.LibroRequestDTO;
import com.example.template.dtos.LibroResponseDTO;

import com.example.template.exceptions.LibroDontFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILibroService {
    LibroResponseDTO create(LibroRequestDTO LibroRequestDTO);
    LibroResponseDTO getById(long id) throws LibroDontFoundException;
    List<LibroResponseDTO> getAll();
    LibroResponseDTO update(long id, LibroRequestDTO LibroRequestDTO) throws LibroDontFoundException;
    boolean delete(long id) throws LibroDontFoundException;
}
