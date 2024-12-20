package org.enoca.challenge.order.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import org.enoca.challenge.core.entities.BaseEntity;
import org.enoca.challenge.product.entities.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
public class OrderRow extends BaseEntity<String> {

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    private Double quantity;

    private BigDecimal unitPrice;

    public BigDecimal getRowSum() {

        return product.getCurrentPrice().multiply(BigDecimal.valueOf(quantity));

    }

    public BigDecimal getRowTax() {

        return this.product.getCurrentPrice()
                .divide(BigDecimal.valueOf(100), RoundingMode.valueOf(4))
                .multiply(BigDecimal.valueOf(product.getTaxRate()));

    }

    public BigDecimal getRowTotal() {

        return this.getRowSum().add(getRowTax());

    }

    public Product getProduct() {

        return product;

    }

    public void setProduct(Product product) {

        if (product == null) {

            throw new RuntimeException("Product cannot be null");

        }
        this.product = product;
    }

    public Double getQuantity() {

        return quantity;
    }

    public void setQuantity(Double quantity) {

        if (quantity < 0) {

            throw new RuntimeException("Quantity cannot be less than zero");

        }

        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {

        if (unitPrice.compareTo(BigDecimal.ZERO) < 0) {

            throw new RuntimeException("Unit price cannot be less than zero");
        }

        this.unitPrice = unitPrice;

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
