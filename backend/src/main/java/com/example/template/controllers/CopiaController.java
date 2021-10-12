package com.example.template.controllers;

import com.example.template.dtos.CopiaRequestDTO;
import com.example.template.dtos.CopiaResponseDTO;
import com.example.template.exceptions.CopiaDontFoundException;
import com.example.template.services.ICopiaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/Copia")
@AllArgsConstructor
public class CopiaController {

    protected ICopiaService iCopiaService;
    @PostMapping("/")
    public ResponseEntity<CopiaResponseDTO> create(@Valid @RequestBody CopiaRequestDTO CopiaRequestDTO){
        return new ResponseEntity<>(iCopiaService.create(CopiaRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CopiaResponseDTO> getById(@PathVariable long id) throws CopiaDontFoundException {
        return new ResponseEntity<>(iCopiaService.getById(id),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<CopiaResponseDTO>> getAll(){
        return new ResponseEntity<>(iCopiaService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CopiaResponseDTO> update(@PathVariable long id, @Valid @RequestBody CopiaRequestDTO CopiaRequestDTO) throws CopiaDontFoundException {
        return new ResponseEntity<>(iCopiaService.update(id,CopiaRequestDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) throws CopiaDontFoundException {
        return new ResponseEntity<>(iCopiaService.delete(id),HttpStatus.NO_CONTENT);
    }
}
