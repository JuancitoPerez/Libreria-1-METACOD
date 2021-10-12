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
@Table(name = "Copia")
public class Copia {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long CopiaId;
private LocalDate FechaFinVigencia;
private LocalDate FechaInicioVigencia;
private EstadoCopia Estado;
}
