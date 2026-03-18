package com.ceiba.fondos.infrastructure.outbound.client.controller;

import com.ceiba.fondos.application.usecase.SuscribirseFondoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final SuscribirseFondoUseCase useCase;

    public ClienteController(SuscribirseFondoUseCase useCase) {
        this.useCase = useCase;
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
}
