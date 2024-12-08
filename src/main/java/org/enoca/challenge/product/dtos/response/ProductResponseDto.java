package org.enoca.challenge.product.dtos.response;

import org.enoca.challenge.core.dtos.responses.ResponseDto;
import org.enoca.challenge.unit.dtos.responses.UnitResponseDto;

import java.math.BigDecimal;
import java.time.Instant;

public class ProductResponseDto extends ResponseDto<String> {

    private final String name;

    private final UnitResponseDto unit;

    private final Double taxRate;

    private final BigDecimal currentPrice;

    private final Float stockAmount;

    public ProductResponseDto(String id, Instant createdAt, Instant editedAt, String name, UnitResponseDto unit, Double taxRate, BigDecimal currentPrice, Float stockAmount) {
        super(id, createdAt, editedAt);
        this.name = name;
        this.unit = unit;
        this.taxRate = taxRate;
        this.currentPrice = currentPrice;
        this.stockAmount = stockAmount;
    }

    public String getName() {
        return name;
    }

    public UnitResponseDto getUnit() {
        return unit;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public Float getStockAmount() {
        return stockAmount;
    }
}
