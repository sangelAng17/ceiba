package com.ceiba.fondos.infrastructure.outbound.persistence.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class SuscripcionDocument {

    private Integer fondoId;
    private String nombreFondo;
    private double monto;
    private LocalDate fecha;
}
