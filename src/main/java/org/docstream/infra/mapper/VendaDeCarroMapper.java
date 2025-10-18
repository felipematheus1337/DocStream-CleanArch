package org.docstream.infra.mapper;

import org.docstream.domain.VendaDeCarro;
import org.docstream.infra.persistence.VendaDeCarroEntity;

public class VendaDeCarroMapper {

    public static VendaDeCarroEntity toEntity(VendaDeCarro vendaDeCarro) {
        VendaDeCarroEntity venda = new VendaDeCarroEntity();
        venda.setMarca(vendaDeCarro.getMarca());
        venda.setNome(vendaDeCarro.getNome());
        venda.setPrice(vendaDeCarro.getPrice());
        venda.setAnoDeFabricacao(vendaDeCarro.getAnoDeFabricacao());
        return venda;
    }
}
