package com.example.template.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaRequestDTO {
private String Nombre;
private String Apellido;
private Date FechaNacimiento;
private String Nacionalidad;
}
