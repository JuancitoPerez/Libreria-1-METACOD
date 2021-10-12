package com.example.template.mappers;

import com.example.template.dtos.PrestamoRequestDTO;
import com.example.template.dtos.PrestamoResponseDTO;
import com.example.template.model.Prestamo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MapperPrestamo {

    public Prestamo toPrestamo(PrestamoRequestDTO PrestamoRequestDTO){
        Prestamo Prestamo = new Prestamo();
        Prestamo.setFechaInicio(PrestamoRequestDTO.getFechaInicio());
        Prestamo.setFechaFin(PrestamoRequestDTO.getFechaFin());

        return Prestamo;
    }

    public Prestamo toPrestamo(PrestamoRequestDTO PrestamoRequestDTO, long id){
        Prestamo Prestamo = new Prestamo();
        Prestamo.setFechaInicio(PrestamoRequestDTO.getFechaInicio());
        Prestamo.setFechaFin(PrestamoRequestDTO.getFechaFin());

        return Prestamo;
    }

    public PrestamoResponseDTO toPrestamoResponseDTO(Prestamo Prestamo){
        PrestamoResponseDTO PrestamoResponseDTO = new PrestamoResponseDTO();
        PrestamoResponseDTO.setFechaInicio(Prestamo.getFechaInicio());
        PrestamoResponseDTO.setFechaFin(Prestamo.getFechaFin());

        return PrestamoResponseDTO;
    }

}
