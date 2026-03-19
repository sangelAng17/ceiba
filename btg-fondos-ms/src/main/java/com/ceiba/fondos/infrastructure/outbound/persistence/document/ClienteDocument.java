package com.ceiba.fondos.infrastructure.outbound.persistence.document;

import com.ceiba.fondos.domain.model.Transaccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientes")
@Data
public class ClienteDocument {

    @Id
    private String id;
    private String nombre;
    private double saldo;
    private List<SuscripcionDocument> suscripciones;
    private List<TransaccionDocument> transacciones;
}