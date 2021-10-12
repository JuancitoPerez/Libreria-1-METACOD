package com.example.template.services;

import com.example.template.dtos.AutorRequestDTO;
import com.example.template.dtos.AutorResponseDTO;

import com.example.template.exceptions.AutorDontFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAutorService {
    AutorResponseDTO create(AutorRequestDTO AutorRequestDTO);
    AutorResponseDTO getById(long id) throws AutorDontFoundException;
    List<AutorResponseDTO> getAll();
    AutorResponseDTO update(long id, AutorRequestDTO AutorRequestDTO) throws AutorDontFoundException;
    boolean delete(long id) throws AutorDontFoundException;
}
