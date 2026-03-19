package com.ceiba.fondos.infrastructure.outbound.persistence.adapter;

import com.ceiba.fondos.domain.model.Cliente;
import com.ceiba.fondos.domain.model.Suscripcion;
import com.ceiba.fondos.domain.model.Transaccion;
import com.ceiba.fondos.domain.ports.ClienteRepository;
import com.ceiba.fondos.infrastructure.outbound.persistence.document.ClienteDocument;
import com.ceiba.fondos.infrastructure.outbound.persistence.document.SuscripcionDocument;
import com.ceiba.fondos.infrastructure.outbound.persistence.document.TransaccionDocument;
import com.ceiba.fondos.infrastructure.outbound.persistence.mapper.ClienteMapper;
import com.ceiba.fondos.infrastructure.outbound.persistence.repository.ClienteMongoRepository;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
@Component
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteMongoRepository repository;
    private final ClienteMapper mapper;

    public ClienteRepositoryAdapter(
            ClienteMongoRepository repository,
            ClienteMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Cliente obtener(String id) {

        var document = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        var suscripciones = document.getSuscripciones() == null
                ? new ArrayList<Suscripcion>()
                : document.getSuscripciones()
                .stream()
                .map(s -> new Suscripcion(
                        s.getFondoId(),
                        s.getNombreFondo(),
                        s.getMonto(),
                        s.getFecha()
                ))
                .collect(java.util.stream.Collectors.toList());

        var transacciones = document.getTransacciones() == null
                ? new ArrayList<Transaccion>()
                : document.getTransacciones().stream()
                .map(t -> new Transaccion(
                        t.getTipo(),
                        t.getFondoId(),
                        t.getNombreFondo(),
                        t.getMonto(),
                        t.getFecha()
                ))
                .collect(java.util.stream.Collectors.toList());

        return new Cliente(
                document.getId(),
                document.getNombre(),
                document.getSaldo(),
                suscripciones,
                transacciones
        );
    }

    @Override
    public void guardar(Cliente cliente) {

        var suscripciones = cliente.getSuscripciones() == null
                ? new ArrayList<SuscripcionDocument>()
                : cliente.getSuscripciones()
                .stream()
                .map(s -> new SuscripcionDocument(
                        s.getFondoId(),
                        s.getNombreFondo(),
                        s.getMonto(),
                        s.getFecha()
                ))
                .collect(java.util.stream.Collectors.toList());

        var transacciones = cliente.getTransacciones() == null
                ? new ArrayList<TransaccionDocument>()
                : cliente.getTransacciones().stream()
                .map(t -> new TransaccionDocument(
                        t.getTipo(),
                        t.getFondoId(),
                        t.getNombreFondo(),
                        t.getMonto(),
                        t.getFecha()
                ))
                .collect(java.util.stream.Collectors.toList());

        var document = new ClienteDocument(
                cliente.getId(),
                cliente.getNombre(),
                cliente.getSaldo(),
                suscripciones,
                transacciones
        );

        repository.save(document);
    }
}
