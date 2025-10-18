package org.docstream.infra.controller;

import io.vertx.ext.web.FileUpload;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.docstream.application.usecases.CriarVendaDeCarroJSON;
import org.docstream.application.usecases.CriarVendaDeCarroXML;
import org.docstream.domain.VendaDeCarro;
import org.docstream.infra.controller.request.VendaDeCarroRequest;
import org.docstream.infra.mapper.VendaDeCarroMapper;

@ApplicationScoped
@Path("/vendas")
public class VendaDeCarroController {

    private final CriarVendaDeCarroJSON criarVendaDeCarroJSON;
    private final CriarVendaDeCarroXML criarVendaDeCarroXML;

    @Inject
    public VendaDeCarroController(CriarVendaDeCarroJSON criarVendaDeCarroJSON, CriarVendaDeCarroXML criarVendaDeCarroXML) {
        this.criarVendaDeCarroJSON = criarVendaDeCarroJSON;
        this.criarVendaDeCarroXML = criarVendaDeCarroXML;
    }

    @POST
    @Path("/json")
    public Response criarCarroViaJSON(VendaDeCarroRequest request) {
        VendaDeCarro vendaDeCarro = VendaDeCarroMapper.toDomain(request);
        criarVendaDeCarroJSON.executar(vendaDeCarro);
        return Response.accepted().build();
    }

    @POST
    @Path("/xml")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response criarCarroViaXML(FileUpload fileUpload) {
        criarVendaDeCarroXML.executar(fileUpload);
        return Response.accepted().build();
    }

}
