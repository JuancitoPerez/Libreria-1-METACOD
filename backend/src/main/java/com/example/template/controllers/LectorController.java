package com.example.template.controllers;

import com.example.template.dtos.LectorRequestDTO;
import com.example.template.dtos.LectorResponseDTO;
import com.example.template.exceptions.LectorDontFoundException;
import com.example.template.services.ILectorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/Lector")
@AllArgsConstructor
public class LectorController {

    protected ILectorService iLectorService;
    @PostMapping("/")
    public ResponseEntity<LectorResponseDTO> create(@Valid @RequestBody LectorRequestDTO LectorRequestDTO){
        return new ResponseEntity<>(iLectorService.create(LectorRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LectorResponseDTO> getById(@PathVariable long id) throws LectorDontFoundException {
        return new ResponseEntity<>(iLectorService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<LectorResponseDTO>> getAll(){
        return new ResponseEntity<>(iLectorService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LectorResponseDTO> update(@PathVariable long id, @Valid @RequestBody LectorRequestDTO LectorRequestDTO) throws LectorDontFoundException {
        return new ResponseEntity<>(iLectorService.update(id,LectorRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) throws LectorDontFoundException {
        return new ResponseEntity<>(iLectorService.delete(id),HttpStatus.NO_CONTENT);
    }
}
