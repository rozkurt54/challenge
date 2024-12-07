package org.enoca.challenge.chart.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.enoca.challenge.core.entities.BaseEntity;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Chart extends BaseEntity<String> {

    @OneToMany
    private List<ChartRow> cartRows;

    private BigDecimal getCartItemsPriceSum() {

        if (cartRows.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal cartItemsPriceSum = BigDecimal.ZERO;

        for (ChartRow row : cartRows) {

            if (row.getRowSum().compareTo(BigDecimal.ZERO) != 0) {

                cartItemsPriceSum = cartItemsPriceSum.add(row.getRowSum());

            }

        }

        return cartItemsPriceSum;

    }

    public BigDecimal getItemsTaxSum() {

        if (cartRows.isEmpty()) {

            return BigDecimal.ZERO;

        }

        BigDecimal cartItemsTaxSum = BigDecimal.ZERO;

        for (ChartRow row : cartRows) {

            if(row.getRowTax().compareTo(BigDecimal.ZERO) != 0) {

                cartItemsTaxSum = cartItemsTaxSum.add(row.getRowTax());

            }

        }

        return cartItemsTaxSum;
    }

    public BigDecimal getCartTotal() {

        return getCartItemsPriceSum().add(getItemsTaxSum());

    }

    public List<ChartRow> getCartRows() {
        return cartRows;
    }

    public void setCartRows(List<ChartRow> cartRows) {
        this.cartRows = cartRows;
    }
}
