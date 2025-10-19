package org.docstream.application.gateways;

import io.vertx.ext.web.FileUpload;

import java.io.InputStream;

public interface VendaDeCarroGatewayCSV {

    void persistir(InputStream inputStream);
}
