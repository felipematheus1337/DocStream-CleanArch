package org.docstream.infra.persistence;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@MongoEntity(collection = "vendas_de_carros")
public class VendaDeCarroEntity extends PanacheMongoEntity {

    private String nome;
    private String marca;
    private LocalDateTime anoDeFabricacao;
    private BigDecimal price;

    public VendaDeCarroEntity() {
    }

    public VendaDeCarroEntity(String nome, String marca, LocalDateTime anoDeFabricacao, BigDecimal price) {
        this.nome = nome;
        this.marca = marca;
        this.anoDeFabricacao = anoDeFabricacao;
        this.price = price;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(LocalDateTime anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }
}
