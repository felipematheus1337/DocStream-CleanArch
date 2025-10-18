package org.docstream.infra.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import org.docstream.application.gateways.VendaDeCarroGatewayJSON;
import org.docstream.application.gateways.VendaDeCarroGatewayXML;
import org.docstream.application.usecases.CriarVendaDeCarroJSON;
import org.docstream.application.usecases.CriarVendaDeCarroXML;

@ApplicationScoped
public class UseCaseProvider {

    @Inject
    VendaDeCarroGatewayJSON vendaDeCarroGatewayJSON;

    @Inject
    VendaDeCarroGatewayXML vendaDeCarroGatewayXML;

    @Produces
    public CriarVendaDeCarroJSON criarVendaDeCarroJSON() {
        return new CriarVendaDeCarroJSON(vendaDeCarroGatewayJSON);
    }

    @Produces
    public CriarVendaDeCarroXML criarVendaDeCarroXML() {
        return new CriarVendaDeCarroXML(vendaDeCarroGatewayXML);
    }
}
