package org.docstream.application.usecases;

import io.vertx.ext.web.FileUpload;
import org.docstream.application.exceptions.DomainException;
import org.docstream.application.gateways.VendaDeCarroGatewayXML;

import java.io.InputStream;

public class CriarVendaDeCarroXML {

    private final VendaDeCarroGatewayXML vendaDeCarroGatewayXML;

    public CriarVendaDeCarroXML(VendaDeCarroGatewayXML vendaDeCarroGatewayXML) {
        this.vendaDeCarroGatewayXML = vendaDeCarroGatewayXML;
    }

    public void executar(InputStream inputStream) {
        vendaDeCarroGatewayXML.persistir(inputStream);
    }
}
