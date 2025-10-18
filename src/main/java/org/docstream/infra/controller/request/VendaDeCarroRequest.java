package org.docstream.infra.controller.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VendaDeCarroRequest(String marca, String nome, BigDecimal price, LocalDateTime anoDeFabricacao) {
}
