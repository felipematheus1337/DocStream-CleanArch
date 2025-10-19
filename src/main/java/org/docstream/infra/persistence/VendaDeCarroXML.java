package org.docstream.infra.persistence;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.docstream.infra.config.LocalDateTimeAdapter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "venda")
@XmlAccessorType(XmlAccessType.FIELD) // <- importante
public class VendaDeCarroXML {

    private String nome;
    private String marca;

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime anoDeFabricacao;

    private BigDecimal price;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public LocalDateTime getAnoDeFabricacao() { return anoDeFabricacao; }
    public void setAnoDeFabricacao(LocalDateTime anoDeFabricacao) { this.anoDeFabricacao = anoDeFabricacao; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
