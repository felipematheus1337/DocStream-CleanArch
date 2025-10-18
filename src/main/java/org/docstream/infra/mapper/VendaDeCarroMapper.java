package org.docstream.infra.mapper;

import org.docstream.domain.VendaDeCarro;
import org.docstream.infra.controller.request.VendaDeCarroRequest;
import org.docstream.infra.persistence.VendaDeCarroEntity;
import org.docstream.infra.persistence.VendaDeCarroXML;

public class VendaDeCarroMapper {

    public static VendaDeCarroEntity toEntity(VendaDeCarro vendaDeCarro) {
        VendaDeCarroEntity venda = new VendaDeCarroEntity();
        venda.setMarca(vendaDeCarro.getMarca());
        venda.setNome(vendaDeCarro.getNome());
        venda.setPrice(vendaDeCarro.getPrice());
        venda.setAnoDeFabricacao(vendaDeCarro.getAnoDeFabricacao());
        return venda;
    }

    public static VendaDeCarro toDomain(VendaDeCarroRequest request) {
        VendaDeCarro vendaDeCarro = new VendaDeCarro();
        vendaDeCarro.setMarca(request.marca());
        vendaDeCarro.setNome(request.nome());
        vendaDeCarro.setPrice(request.price());
        vendaDeCarro.setAnoDeFabricacao(request.anoDeFabricacao());
        return vendaDeCarro;
    }

    public static VendaDeCarroEntity xmlToEntity(VendaDeCarroXML vendaDeCarroXML) {
        VendaDeCarroEntity entity = new VendaDeCarroEntity();
        entity.setNome(vendaDeCarroXML.getNome());
        entity.setMarca(vendaDeCarroXML.getMarca());
        entity.setPrice(vendaDeCarroXML.getPrice());
        entity.setAnoDeFabricacao(vendaDeCarroXML.getAnoDeFabricacao());
        return entity;
    }
}
