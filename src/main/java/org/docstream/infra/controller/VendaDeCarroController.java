package org.docstream.infra.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.docstream.application.usecases.CriarVendaDeCarroJSON;
import org.docstream.domain.VendaDeCarro;
import org.docstream.infra.controller.request.VendaDeCarroRequest;
import org.docstream.infra.mapper.VendaDeCarroMapper;

@ApplicationScoped
@Path("/vendas")
public class VendaDeCarroController {

    private final CriarVendaDeCarroJSON criarVendaDeCarroJSON;

    public VendaDeCarroController(CriarVendaDeCarroJSON criarVendaDeCarroJSON) {
        this.criarVendaDeCarroJSON = criarVendaDeCarroJSON;
    }

    @POST
    @Path("/json")
    public Response criarCarroViaJSON(VendaDeCarroRequest request) {
        VendaDeCarro vendaDeCarro = VendaDeCarroMapper.toDomain(request);
        criarVendaDeCarroJSON.executar(vendaDeCarro);
        return Response.accepted().build();
    }

}
