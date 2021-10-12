package com.example.template.services;

import com.example.template.dtos.CopiaRequestDTO;
import com.example.template.dtos.CopiaResponseDTO;

import com.example.template.exceptions.CopiaDontFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICopiaService {
    CopiaResponseDTO create(CopiaRequestDTO CopiaRequestDTO);
    CopiaResponseDTO getById(long id) throws CopiaDontFoundException;
    List<CopiaResponseDTO> getAll();
    CopiaResponseDTO update(long id, CopiaRequestDTO CopiaRequestDTO) throws CopiaDontFoundException;
    boolean delete(long id) throws CopiaDontFoundException;
}
