package com.example.template.mappers;

import com.example.template.dtos.LibroRequestDTO;
import com.example.template.dtos.LibroResponseDTO;
import com.example.template.model.Libro;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperLibro {

    public Libro toLibro(LibroRequestDTO LibroRequestDTO){
        Libro Libro = new Libro();
        Libro.setTitulo(LibroRequestDTO.getTitulo());
        Libro.setGenero(LibroRequestDTO.getGenero());
        Libro.setEditorial(LibroRequestDTO.getEditorial());
        Libro.setFechaPublicación(LibroRequestDTO.getFechaPublicación());
        Libro.setFecha(LibroRequestDTO.getFecha());

        return Libro;
    }

    public Libro toLibro(LibroRequestDTO LibroRequestDTO, long id){
        Libro Libro = new Libro();
        Libro.setTitulo(LibroRequestDTO.getTitulo());
        Libro.setGenero(LibroRequestDTO.getGenero());
        Libro.setEditorial(LibroRequestDTO.getEditorial());
        Libro.setFechaPublicación(LibroRequestDTO.getFechaPublicación());
        Libro.setFecha(LibroRequestDTO.getFecha());

        return Libro;
    }

    public LibroResponseDTO toLibroResponseDTO(Libro Libro){
        LibroResponseDTO LibroResponseDTO = new LibroResponseDTO();
        LibroResponseDTO.setTitulo(Libro.getTitulo());
        LibroResponseDTO.setGenero(Libro.getGenero());
        LibroResponseDTO.setEditorial(Libro.getEditorial());
        LibroResponseDTO.setFechaPublicación(Libro.getFechaPublicación());
        LibroResponseDTO.setFecha(Libro.getFecha());

        return LibroResponseDTO;
    }

}
