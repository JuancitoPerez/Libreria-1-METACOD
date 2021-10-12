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
@Table(name = "Multa")
public class Multa {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long MultaId;
private LocalDate FechaFinVigencia;
private LocalDate FechaInicioVigencia;
private Date FechaInicio;
private Date FechaFin;
}
