package org.docstream.infra.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import org.docstream.application.gateways.VendaDeCarroGatewayJSON;
import org.docstream.application.usecases.CriarVendaDeCarroJSON;

@ApplicationScoped
public class UseCaseProvider {

    @Inject
    VendaDeCarroGatewayJSON vendaDeCarroGatewayJSON;

    @Produces
    public CriarVendaDeCarroJSON criarVendaDeCarroJSON() {
        return new CriarVendaDeCarroJSON(vendaDeCarroGatewayJSON);
    }
}
