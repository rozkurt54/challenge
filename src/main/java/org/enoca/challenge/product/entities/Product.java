package org.enoca.challenge.product.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import org.enoca.challenge.core.entities.BaseEntity;
import org.enoca.challenge.unit.entities.Unit;

import java.math.BigDecimal;

@Entity
public class Product extends BaseEntity<String> {

    private String name;

    @OneToOne
    private Unit unit;

    private BigDecimal taxRate;

    private BigDecimal currentPrice;

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

    public BigDecimal getTaxRate() {

        return taxRate;

    }

    public void setTaxRate(BigDecimal taxRate) {

        if (taxRate.compareTo(BigDecimal.ZERO) < 0) {

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
}
