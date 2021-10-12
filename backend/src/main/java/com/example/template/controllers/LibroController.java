package com.example.template.controllers;

import com.example.template.dtos.LibroRequestDTO;
import com.example.template.dtos.LibroResponseDTO;
import com.example.template.exceptions.LibroDontFoundException;
import com.example.template.services.ILibroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/Libro")
@AllArgsConstructor
public class LibroController {

    protected ILibroService iLibroService;
    @PostMapping("/")
    public ResponseEntity<LibroResponseDTO> create(@Valid @RequestBody LibroRequestDTO LibroRequestDTO){
        return new ResponseEntity<>(iLibroService.create(LibroRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> getById(@PathVariable long id) throws LibroDontFoundException {
        return new ResponseEntity<>(iLibroService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<LibroResponseDTO>> getAll(){
        return new ResponseEntity<>(iLibroService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroResponseDTO> update(@PathVariable long id, @Valid @RequestBody LibroRequestDTO LibroRequestDTO) throws LibroDontFoundException {
        return new ResponseEntity<>(iLibroService.update(id,LibroRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) throws LibroDontFoundException {
        return new ResponseEntity<>(iLibroService.delete(id),HttpStatus.NO_CONTENT);
    }
}
