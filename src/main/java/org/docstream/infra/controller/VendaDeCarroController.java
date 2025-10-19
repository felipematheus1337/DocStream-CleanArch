package org.docstream.infra.controller;

import io.vertx.ext.web.FileUpload;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.docstream.application.usecases.CriarVendaDeCarroCSV;
import org.docstream.application.usecases.CriarVendaDeCarroJSON;
import org.docstream.application.usecases.CriarVendaDeCarroXML;
import org.docstream.domain.VendaDeCarro;
import org.docstream.infra.controller.request.VendaDeCarroRequest;
import org.docstream.infra.mapper.VendaDeCarroMapper;

import java.io.InputStream;

@ApplicationScoped
@Path("/vendas")
public class VendaDeCarroController {

    private CriarVendaDeCarroJSON criarVendaDeCarroJSON;
    private CriarVendaDeCarroXML criarVendaDeCarroXML;
    private CriarVendaDeCarroCSV criarVendaDeCarroCSV;

    @Inject
    public VendaDeCarroController(CriarVendaDeCarroJSON criarVendaDeCarroJSON, CriarVendaDeCarroXML criarVendaDeCarroXML, CriarVendaDeCarroCSV criarVendaDeCarroCSV) {
        this.criarVendaDeCarroJSON = criarVendaDeCarroJSON;
        this.criarVendaDeCarroXML = criarVendaDeCarroXML;
        this.criarVendaDeCarroCSV = criarVendaDeCarroCSV;
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
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public Response criarCarroViaXML(InputStream inputStream) {
        criarVendaDeCarroXML.executar(inputStream);
        return Response.accepted().build();
    }

    @POST
    @Path("/csv")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public Response criarCarroViaCSV(InputStream inputStream) {
        criarVendaDeCarroCSV.executar(inputStream);
        return Response.accepted().build();
    }

}
