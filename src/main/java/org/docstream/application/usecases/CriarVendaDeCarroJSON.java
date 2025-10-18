package org.docstream.application.usecases;

import org.docstream.application.exceptions.DomainException;
import org.docstream.application.gateway.VendaDeCarroGatewayJSON;
import org.docstream.domain.VendaDeCarro;

import java.math.BigDecimal;

public class CriarVendaDeCarroJSON {

    private final VendaDeCarroGatewayJSON vendaDeCarroGatewayJSON;

    public CriarVendaDeCarroJSON(VendaDeCarroGatewayJSON vendaDeCarroGatewayJSON) {
        this.vendaDeCarroGatewayJSON = vendaDeCarroGatewayJSON;
    }

    public void executar(VendaDeCarro vendaDeCarro) {
        if (vendaDeCarro.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new DomainException("Não é possível realizar salvamento de venda com pagamento de zero pra baixo");
        }

        this.vendaDeCarroGatewayJSON.salvar(vendaDeCarro);
    }
}
