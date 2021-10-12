package com.example.template.controllers;

import com.example.template.dtos.MultaRequestDTO;
import com.example.template.dtos.MultaResponseDTO;
import com.example.template.exceptions.MultaDontFoundException;
import com.example.template.services.IMultaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/Multa")
@AllArgsConstructor
public class MultaController {

    protected IMultaService iMultaService;
    @PostMapping("/")
    public ResponseEntity<MultaResponseDTO> create(@Valid @RequestBody MultaRequestDTO MultaRequestDTO){
        return new ResponseEntity<>(iMultaService.create(MultaRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MultaResponseDTO> getById(@PathVariable long id) throws MultaDontFoundException {
        return new ResponseEntity<>(iMultaService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<MultaResponseDTO>> getAll(){
        return new ResponseEntity<>(iMultaService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MultaResponseDTO> update(@PathVariable long id, @Valid @RequestBody MultaRequestDTO MultaRequestDTO) throws MultaDontFoundException {
        return new ResponseEntity<>(iMultaService.update(id,MultaRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) throws MultaDontFoundException {
        return new ResponseEntity<>(iMultaService.delete(id),HttpStatus.NO_CONTENT);
    }
}
