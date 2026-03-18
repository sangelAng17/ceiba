package com.ceiba.fondos.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class Fondo {

    private Integer id;
    private String nombre;
    private double montoMinimo;
    private String categoria;
}
