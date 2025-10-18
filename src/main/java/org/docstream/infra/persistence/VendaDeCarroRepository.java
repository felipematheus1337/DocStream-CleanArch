package org.docstream.infra.persistence;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VendaDeCarroRepository implements PanacheMongoRepository<VendaDeCarroEntity> {
}
