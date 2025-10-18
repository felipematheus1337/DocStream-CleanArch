package org.docstream.infra.persistence;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "venda")
public class VendaDeCarroXML {

    private String nome;
    private String marca;
    private LocalDateTime anoDeFabricacao;
    private BigDecimal price;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDateTime getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(LocalDateTime anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
