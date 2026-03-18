package com.ceiba.fondos.infrastructure.outbound.persistence.repository;


import com.ceiba.fondos.infrastructure.outbound.persistence.document.ClienteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteMongoRepository
        extends MongoRepository<ClienteDocument, String> {
}
