package com.ceiba.fondos.infrastructure.outbound.client.controller;

import com.ceiba.fondos.application.usecase.SuscribirseFondoUseCase;
import com.ceiba.fondos.domain.model.Cliente;
import com.ceiba.fondos.domain.model.Transaccion;
import com.ceiba.fondos.domain.ports.ClienteRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
     SuscribirseFondoUseCase useCase;

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteController(
            SuscribirseFondoUseCase useCase) {
        this.useCase = useCase;
        this.clienteRepository = clienteRepository;
    }


    @Operation(
            summary = "Creacion de la suscripcion del proceso",
            description = "Servicio usado para la suscripcion en el proceso"
    )
    @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Suscripcion realizada"),
            @ApiResponse(responseCode = "400", description = "Parámetro inválido")
    })
    @PostMapping("/{clienteId}/suscripciones/{fondoId}")
    public ResponseEntity<Void> suscribirse(
            @PathVariable String clienteId,
            @PathVariable Integer fondoId
    ) {

        useCase.ejecutar(clienteId, fondoId);

        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "eliminacion de la suscripcion del proceso",
            description = "Servicio usado para la eliminacion  en el proceso"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "cancelacion realizada"),
            @ApiResponse(responseCode = "400", description = "Parámetro inválido")
    })
    @DeleteMapping("/clientes/{clienteId}/suscripciones/{fondoId}")
    public void cancelar(@PathVariable String clienteId,
                         @PathVariable Integer fondoId) {

        useCase.cancelar(clienteId, fondoId);
    }


    @Operation(
            summary = "consulta de las transacciones del proceso",
            description = "Servicio usado para la onsulta de las transacciones del proceso"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "consulta realizada"),
            @ApiResponse(responseCode = "400", description = "Parámetro inválido")
    })
    @GetMapping("/clientes/{clienteId}/transacciones")
    public ResponseEntity<List<Transaccion>> historial(@PathVariable String clienteId) {

        Cliente cliente = clienteRepository.obtener(clienteId);

        return ResponseEntity.ok(cliente.getTransacciones());
    }
}
