package com.example.template.controllers;

import com.example.template.dtos.PrestamoRequestDTO;
import com.example.template.dtos.PrestamoResponseDTO;
import com.example.template.exceptions.PrestamoDontFoundException;
import com.example.template.services.IPrestamoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/Prestamo")
@AllArgsConstructor
public class PrestamoController {

    protected IPrestamoService iPrestamoService;
    @PostMapping("/")
    public ResponseEntity<PrestamoResponseDTO> create(@Valid @RequestBody PrestamoRequestDTO PrestamoRequestDTO){
        return new ResponseEntity<>(iPrestamoService.create(PrestamoRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoResponseDTO> getById(@PathVariable long id) throws PrestamoDontFoundException {
        return new ResponseEntity<>(iPrestamoService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<PrestamoResponseDTO>> getAll(){
        return new ResponseEntity<>(iPrestamoService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestamoResponseDTO> update(@PathVariable long id, @Valid @RequestBody PrestamoRequestDTO PrestamoRequestDTO) throws PrestamoDontFoundException {
        return new ResponseEntity<>(iPrestamoService.update(id,PrestamoRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) throws PrestamoDontFoundException {
        return new ResponseEntity<>(iPrestamoService.delete(id),HttpStatus.NO_CONTENT);
    }
}
