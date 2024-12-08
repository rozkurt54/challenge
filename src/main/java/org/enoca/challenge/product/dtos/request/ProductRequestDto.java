package org.enoca.challenge.product.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.enoca.challenge.core.dtos.requests.IRequestDto;
import org.enoca.challenge.core.validations.annotations.NotNegative;

import java.math.BigDecimal;

public class ProductRequestDto implements IRequestDto {

    @NotBlank
    @NotNull
    private final String name;

    @NotBlank
    @NotNull
    private final String unitId;

    @NotNegative
    private final Float stockAmount;

    @NotNegative
    private final Double taxRate;

    @NotNegative
    private final BigDecimal currentPrice;

    public ProductRequestDto(String name,
                             String unitId,
                             Float stockAmount,
                             double taxRate,
                             BigDecimal currentPrice) {
        this.name = name;
        this.unitId = unitId;
        this.stockAmount = stockAmount;
        this.taxRate = taxRate;
        this.currentPrice = currentPrice;
    }

    public String getName() {

        return name;

    }

    public String getUnitId() {

        return unitId;

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
