package org.docstream.infra.gateways;

import io.vertx.ext.web.FileUpload;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.docstream.application.gateways.VendaDeCarroGatewayXML;
import org.docstream.infra.mapper.VendaDeCarroMapper;
import org.docstream.infra.persistence.VendaDeCarroEntity;
import org.docstream.infra.persistence.VendaDeCarroRepository;
import org.docstream.infra.persistence.VendaDeCarroXML;
import org.docstream.infra.service.SerializadorDeArquivosXMLService;

@ApplicationScoped
public class VendaDeCarroGatewayXMLImpl implements VendaDeCarroGatewayXML {

    @Inject
    private final VendaDeCarroRepository repository;
    private final SerializadorDeArquivosXMLService serializadorDeArquivosXMLService;

    public VendaDeCarroGatewayXMLImpl(VendaDeCarroRepository repository, SerializadorDeArquivosXMLService serializadorDeArquivosXMLService) {
        this.repository = repository;
        this.serializadorDeArquivosXMLService = serializadorDeArquivosXMLService;
    }

    @Override
    public void persistir(FileUpload fileUpload) {
         try {
             VendaDeCarroXML xml = serializadorDeArquivosXMLService.serializar(fileUpload, VendaDeCarroXML.class);
             VendaDeCarroEntity entity = VendaDeCarroMapper.xmlToEntity(xml);
             repository.persist(entity);

         } catch(Exception e) {
             throw new RuntimeException();
         }

    }

}
