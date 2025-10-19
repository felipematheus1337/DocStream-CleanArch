package org.docstream.infra.gateways;

import io.vertx.ext.web.FileUpload;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.docstream.application.gateways.VendaDeCarroGatewayCSV;
import org.docstream.domain.VendaDeCarro;
import org.docstream.infra.mapper.VendaDeCarroMapper;
import org.docstream.infra.persistence.VendaDeCarroEntity;
import org.docstream.infra.persistence.VendaDeCarroRepository;
import org.docstream.infra.service.SerializadorDeArquivosCSVService;

import java.io.InputStream;
import java.util.List;

@ApplicationScoped
public class VendaDeCarroGatewayCSVImpl implements VendaDeCarroGatewayCSV  {

    private final VendaDeCarroRepository repository;
    private final SerializadorDeArquivosCSVService csvService;

    @Inject
    public VendaDeCarroGatewayCSVImpl(VendaDeCarroRepository repository, SerializadorDeArquivosCSVService csvService) {
        this.repository = repository;
        this.csvService = csvService;
    }

    @Override
    public void persistir(InputStream inputStream) {

        try {
            List<VendaDeCarro> venda = csvService.desserializar(inputStream);

            if (venda.isEmpty())
                return;

            List<VendaDeCarroEntity> entities = venda.stream()
                    .map(VendaDeCarroMapper::toEntity)
                    .toList();

            repository.persist(entities);

        } catch(Exception e) {
            throw new RuntimeException("Falha ao serializar..", e);
        }

    }
}
