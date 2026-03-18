package com.ceiba.fondos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Suscripcion {

    private Integer fondoId;
    private String nombreFondo;
    private double monto;
    private LocalDate fecha;

}
