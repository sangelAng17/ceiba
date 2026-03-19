package com.ceiba.fondos.application.usecase;

import com.ceiba.fondos.domain.model.Cliente;
import com.ceiba.fondos.domain.model.Fondo;
import com.ceiba.fondos.domain.ports.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class SuscribirseFondoUseCase {

    private final ClienteRepository clienteRepository;

    public SuscribirseFondoUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void ejecutar(String clienteId, Integer fondoId) {

        Cliente cliente = clienteRepository.obtener(clienteId);

        Fondo fondo = obtenerFondo(fondoId);

        cliente.suscribirse(fondo);

        clienteRepository.guardar(cliente);
    }

    public void cancelar(String clienteId, Integer fondoId){
        Cliente cliente = clienteRepository.obtener(clienteId);
        cliente.cancelarSuscripcion(fondoId);
        clienteRepository.guardar(cliente);
    }

    private Fondo obtenerFondo(Integer fondoId) {

        return switch (fondoId) {
            case 1 -> new Fondo(1, "FPV_BTG_PACTUAL_RECAUDADORA", 75000, "FPV");
            case 2 -> new Fondo(2, "FPV_BTG_PACTUAL_ECOPETROL", 125000, "FPV");
            case 3 -> new Fondo(3, "DEUDAPRIVADA", 50000, "FIC");
            case 4 -> new Fondo(4, "FDO-ACCIONES", 250000, "FIC");
            case 5 -> new Fondo(5, "FPV_BTG_PACTUAL_DINAMICA", 100000, "FPV");
            default -> throw new RuntimeException("Fondo no existe");
        };
    }
}
