package com.ceiba.fondos.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    private String id;
    private String nombre;
    private double saldo;
    private List<Suscripcion> suscripciones;

    private List<Transaccion> transacciones;

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

        if (this.transacciones == null) {
            this.transacciones = new java.util.ArrayList<>();
        }

        this.transacciones.add(
                new Transaccion(
                        "APERTURA",
                        fondo.getId(),
                        fondo.getNombre(),
                        fondo.getMontoMinimo(),
                        java.time.LocalDate.now()
                )
        );

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

    public void cancelarSuscripcion(Integer fondoId) {

        if (this.suscripciones == null || this.suscripciones.isEmpty()) {
            throw new RuntimeException("No tiene suscripciones activas");
        }

        Suscripcion suscripcion = this.suscripciones.stream()
                .filter(s -> s.getFondoId().equals(fondoId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No está suscrito a este fondo"));

        this.saldo += suscripcion.getMonto();

        if (this.transacciones == null) {
            this.transacciones = new java.util.ArrayList<>();
        }

        this.transacciones.add(
                new Transaccion(
                        "CANCELACION",
                        suscripcion.getFondoId(),
                        suscripcion.getNombreFondo(),
                        suscripcion.getMonto(),
                        LocalDate.now()
                )
        );

        this.suscripciones.remove(suscripcion);
    }



}
