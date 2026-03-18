package com.ceiba.fondos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    private String id;
    private String nombre;
    private double saldo;
    private List<Suscripcion> suscripciones;

    public void suscribirse(Fondo fondo) {

        if (this.suscripciones == null) {
            this.suscripciones = new java.util.ArrayList<>();
        }

        System.out.println("Saldo cliente: " + this.saldo);
        System.out.println("Monto fondo: " + fondo.getMontoMinimo());

        if (this.saldo < fondo.getMontoMinimo()) {
            throw new RuntimeException(
                    "No tiene saldo disponible para vincularse al fondo " + fondo.getNombre()
            );
        }

        this.saldo -= fondo.getMontoMinimo();

        this.suscripciones.add(
                new Suscripcion(
                        fondo.getId(),
                        fondo.getNombre(),
                        fondo.getMontoMinimo(),
                        java.time.LocalDate.now()
                )
        );
    }
}
