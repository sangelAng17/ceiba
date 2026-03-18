package com.ceiba.fondos.domain.ports;

import com.ceiba.fondos.domain.model.Cliente;

public interface ClienteRepository {

    Cliente obtener(String id);

    void guardar(Cliente cliente);

}