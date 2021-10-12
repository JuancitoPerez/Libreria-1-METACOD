package com.example.template.services;

import com.example.template.dtos.LectorRequestDTO;
import com.example.template.dtos.LectorResponseDTO;

import com.example.template.exceptions.LectorDontFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILectorService {
    LectorResponseDTO create(LectorRequestDTO LectorRequestDTO);
    LectorResponseDTO getById(long id) throws LectorDontFoundException;
    List<LectorResponseDTO> getAll();
    LectorResponseDTO update(long id, LectorRequestDTO LectorRequestDTO) throws LectorDontFoundException;
    boolean delete(long id) throws LectorDontFoundException;
}
