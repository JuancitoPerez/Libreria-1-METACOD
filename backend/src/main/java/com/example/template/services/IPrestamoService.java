package com.example.template.services;

import com.example.template.dtos.PrestamoRequestDTO;
import com.example.template.dtos.PrestamoResponseDTO;

import com.example.template.exceptions.PrestamoDontFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPrestamoService {
    PrestamoResponseDTO create(PrestamoRequestDTO PrestamoRequestDTO);
    PrestamoResponseDTO getById(long id) throws PrestamoDontFoundException;
    List<PrestamoResponseDTO> getAll();
    PrestamoResponseDTO update(long id, PrestamoRequestDTO PrestamoRequestDTO) throws PrestamoDontFoundException;
    boolean delete(long id) throws PrestamoDontFoundException;
}
