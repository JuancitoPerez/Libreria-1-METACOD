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
@Table(name = "Autor")
public class Autor {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long AutorId;
private LocalDate FechaFinVigencia;
private LocalDate FechaInicioVigencia;
private Genero Generos;
}
