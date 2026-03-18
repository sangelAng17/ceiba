package com.ceiba.fondos.infrastructure.outbound.persistence.mapper;

import com.ceiba.fondos.domain.model.Cliente;
import com.ceiba.fondos.infrastructure.outbound.persistence.document.ClienteDocument;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toDomain(ClienteDocument document);

    ClienteDocument toDocument(Cliente cliente);

}