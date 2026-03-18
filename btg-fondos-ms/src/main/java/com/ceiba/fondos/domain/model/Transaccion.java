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
public class Transaccion {

    private String id;
    private String clienteId;
    private String tipo;
    private Integer fondoId;
    private double monto;
    private LocalDate fecha;

}