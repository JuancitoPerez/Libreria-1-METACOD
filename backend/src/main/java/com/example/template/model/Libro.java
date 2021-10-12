package com.example.template.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Libro")
public class Libro {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long LibroId;
private LocalDate FechaFinVigencia;
private LocalDate FechaInicioVigencia;
private String Titulo;
private Genero Genero;
private String Editorial;
private Date FechaPublicación;
private String Fecha;
}
