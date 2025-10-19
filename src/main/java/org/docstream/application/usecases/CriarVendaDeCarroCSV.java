package org.docstream.application.usecases;

import org.docstream.application.gateways.VendaDeCarroGatewayCSV;

import java.io.InputStream;


public class CriarVendaDeCarroCSV {

    private final VendaDeCarroGatewayCSV vendaDeCarroGatewayCSV;

    public CriarVendaDeCarroCSV(VendaDeCarroGatewayCSV vendaDeCarroGatewayCSV) {
        this.vendaDeCarroGatewayCSV = vendaDeCarroGatewayCSV;
    }

    public void executar(InputStream inputStream) {
        vendaDeCarroGatewayCSV.persistir(inputStream);
    }
}
