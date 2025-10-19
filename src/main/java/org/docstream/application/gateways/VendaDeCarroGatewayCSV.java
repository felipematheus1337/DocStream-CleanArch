package org.docstream.application.gateways;


import java.io.InputStream;

public interface VendaDeCarroGatewayCSV {

    void persistir(InputStream inputStream);
}
