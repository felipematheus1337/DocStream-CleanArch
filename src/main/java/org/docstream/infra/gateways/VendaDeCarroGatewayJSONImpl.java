package org.docstream.infra.gateways;

import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.docstream.application.gateways.VendaDeCarroGatewayJSON;
import org.docstream.domain.VendaDeCarro;
import org.docstream.infra.mapper.VendaDeCarroMapper;
import org.docstream.infra.persistence.VendaDeCarroEntity;
import org.docstream.infra.persistence.VendaDeCarroRepository;

@ApplicationScoped
public class VendaDeCarroGatewayJSONImpl implements VendaDeCarroGatewayJSON {

    private final VendaDeCarroRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(VendaDeCarroGatewayJSONImpl.class);

    @Inject
    public VendaDeCarroGatewayJSONImpl(VendaDeCarroRepository repository) {
        this.repository = repository;
    }

    @Override
    public void salvar(VendaDeCarro vendaDeCarro) {

        logger.info("Salvando venda de carro via REST/JSON.");

        VendaDeCarroEntity entity = VendaDeCarroMapper.toEntity(vendaDeCarro);
        repository.persist(entity);
    }
}
