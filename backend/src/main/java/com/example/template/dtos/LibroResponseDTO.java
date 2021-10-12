package com.example.template.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroResponseDTO {
private String Titulo;
private Genero Genero;
private String Editorial;
private Date FechaPublicación;
private String Fecha;
}
