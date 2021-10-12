package com.example.template.services;

import com.example.template.dtos.MultaRequestDTO;
import com.example.template.dtos.MultaResponseDTO;

import com.example.template.exceptions.MultaDontFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMultaService {
    MultaResponseDTO create(MultaRequestDTO MultaRequestDTO);
    MultaResponseDTO getById(long id) throws MultaDontFoundException;
    List<MultaResponseDTO> getAll();
    MultaResponseDTO update(long id, MultaRequestDTO MultaRequestDTO) throws MultaDontFoundException;
    boolean delete(long id) throws MultaDontFoundException;
}
