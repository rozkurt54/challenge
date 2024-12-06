package org.enoca.challenge.entities.concretes.cart;

import jakarta.persistence.Entity;
import org.enoca.challenge.entities.abstracts.AbstractBaseEntity;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Cart extends AbstractBaseEntity<String> {

    private List<CartRow> cartRows;

    private BigDecimal getCartItemsPriceSum() {

        if (cartRows.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal cartItemsPriceSum = BigDecimal.ZERO;

        for (CartRow row : cartRows) {

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

        for (CartRow row : cartRows) {

            if(row.getRowTax().compareTo(BigDecimal.ZERO) != 0) {

                cartItemsTaxSum = cartItemsTaxSum.add(row.getRowTax());

            }

        }

        return cartItemsTaxSum;
    }

    public BigDecimal getCartTotal() {

        return getCartItemsPriceSum().add(getItemsTaxSum());

    }

    public List<CartRow> getCartRows() {
        return cartRows;
    }

    public void setCartRows(List<CartRow> cartRows) {
        this.cartRows = cartRows;
    }
}
