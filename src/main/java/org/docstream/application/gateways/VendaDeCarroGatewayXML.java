package org.docstream.application.gateways;

import io.vertx.ext.web.FileUpload;

public interface VendaDeCarroGatewayXML {

    void persistir(FileUpload fileUpload);
}
