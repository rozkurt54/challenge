package org.enoca.challenge.cart.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.enoca.challenge.core.entities.BaseEntity;
import org.enoca.challenge.customer.entities.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart extends BaseEntity<String> {

    @OneToOne
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER)
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

        if(this.cartRows == null) {
            setCartRows(new ArrayList<>());
        }

        return cartRows;

    }

    public void setCartRows(List<CartRow> cartRows) {

        this.cartRows = cartRows;

    }

    public Customer getCustomer() {

        return customer;

    }

    public void setCustomer(Customer customer) {

        this.customer = customer;

    }
}
