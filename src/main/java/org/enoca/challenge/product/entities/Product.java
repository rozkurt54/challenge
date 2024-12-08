package org.enoca.challenge.product.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.enoca.challenge.core.entities.BaseEntity;
import org.enoca.challenge.unit.entities.Unit;

import java.math.BigDecimal;

@Entity
public class Product extends BaseEntity<String> {

    private String name;

    @ManyToOne
    private Unit unit;

    private Float stockQuantity;

    private Double taxRate;

    private BigDecimal currentPrice;

    //TODO Currencies must be implemented.

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;

    }

    public Unit getUnit() {

        return unit;

    }

    public void setUnit(Unit unit) {

        this.unit = unit;

    }

    public Double getTaxRate() {

        return taxRate;

    }

    public void setTaxRate(Double taxRate) {

        if (taxRate  < 0) {

            throw new RuntimeException("Tax rate cannot be less than zero");

        }

        this.taxRate = taxRate;

    }

    public BigDecimal getCurrentPrice() {

        return currentPrice;

    }

    public void setCurrentPrice(BigDecimal currentPrice) {

        if (currentPrice.compareTo(BigDecimal.ZERO) < 0) {

            throw new RuntimeException("Price cannot be less than zero");

        }

        this.currentPrice = currentPrice;
    }

    public Float getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Float stockQuantity) {

        this.stockQuantity = stockQuantity;

    }
}
