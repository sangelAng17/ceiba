package com.ceiba.fondos.infrastructure.outbound.persistence.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransaccionDocument {

    private String tipo;
    private Integer fondoId;
    private String nombreFondo;
    private double monto;
    private LocalDate fecha;
}
