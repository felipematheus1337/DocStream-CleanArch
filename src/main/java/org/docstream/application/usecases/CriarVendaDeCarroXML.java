package org.docstream.application.usecases;

import io.vertx.ext.web.FileUpload;
import org.docstream.application.exceptions.DomainException;
import org.docstream.application.gateways.VendaDeCarroGatewayXML;

public class CriarVendaDeCarroXML {

    private final VendaDeCarroGatewayXML vendaDeCarroGatewayXML;

    public CriarVendaDeCarroXML(VendaDeCarroGatewayXML vendaDeCarroGatewayXML) {
        this.vendaDeCarroGatewayXML = vendaDeCarroGatewayXML;
    }

    public void executar(FileUpload fileUpload) {
        if (!fileUpload.contentType().contains("xml")) {
            throw new DomainException("Necessário arquivo XML.");
        }

        vendaDeCarroGatewayXML.persistir(fileUpload);
    }
}
