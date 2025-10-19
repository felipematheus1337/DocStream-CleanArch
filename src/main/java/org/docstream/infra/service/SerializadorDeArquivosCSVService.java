package org.docstream.infra.service;

import com.opencsv.CSVReader;
import org.docstream.domain.VendaDeCarro;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SerializadorDeArquivosCSVService {

    public List<VendaDeCarro> desserializar(InputStream inputStream) throws Exception {
         List<VendaDeCarro> vendas = new ArrayList<>();
         try (CSVReader reader = new CSVReader(new InputStreamReader(inputStream))) {

             String[] line;

             boolean isHeader = true;

             while((line = reader.readNext()) != null) {
                 if (isHeader) {
                     isHeader = false;
                     continue;
                 }

                 VendaDeCarro venda = new VendaDeCarro();
                 venda.setNome(line[0]);
                 venda.setMarca(line[1]);
                 venda.setAnoDeFabricacao(LocalDateTime.parse(line[2]));
                 venda.setPrice(new BigDecimal(line[3]));
                 vendas.add(venda);
             }
         }
         return vendas;
    }
}
