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
@Table(name = "Persona")
public class Persona {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long PersonaId;
private LocalDate FechaFinVigencia;
private LocalDate FechaInicioVigencia;
private String Nombre;
private String Apellido;
private Date FechaNacimiento;
private String Nacionalidad;
}
