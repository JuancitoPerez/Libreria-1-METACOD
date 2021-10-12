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
@Table(name = "Lector")
public class Lector {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long LectorId;
private LocalDate FechaFinVigencia;
private LocalDate FechaInicioVigencia;
private int NroSocio;
}
