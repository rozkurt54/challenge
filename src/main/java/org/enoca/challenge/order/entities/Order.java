package org.enoca.challenge.order.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.enoca.challenge.core.entities.BaseEntity;
import org.enoca.challenge.customer.entities.Customer;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders") // The word order is a reserved keyword for mysql.
public class Order extends BaseEntity<String> {

    @ManyToOne
    private Customer customer;

    private Instant orderDate;

    @OneToMany(orphanRemoval = true)
    private List<OrderRow> orderRows;

    private String shippingAddress;

    public Customer getCustomer() {

        return customer;

    }

    public void setCustomer(Customer customer) {

        this.customer = customer;
    }

    public Instant getOrderDate() {

        return orderDate;

    }

    public void setOrderDate(Instant orderDate) {

        this.orderDate = orderDate;

    }

    public List<OrderRow> getOrderRows() {

        if (this.orderRows == null) {

            setOrderRows( new ArrayList<>());
        }

        return orderRows;

    }

    public void setOrderRows(List<OrderRow> orderRows) {

        this.orderRows = orderRows;

    }

    public BigDecimal getTotalTax() {

        var totalTax = BigDecimal.ZERO;

        for(OrderRow orderRow : orderRows) {
            if(orderRow.getRowTax().compareTo(BigDecimal.ZERO) != 0) {
                totalTax = totalTax.add(orderRow.getRowTax());
            }
        }

        return totalTax;

    }

    public  BigDecimal getSubTotal() {

        var subTotal = BigDecimal.ZERO;

        for(OrderRow orderRow : orderRows) {
            if(orderRow.getRowSum().compareTo(BigDecimal.ZERO) != 0) {
                subTotal = subTotal.add(orderRow.getRowSum());
            }
        }

        return subTotal;

    }

    public BigDecimal getGrandTotal() {

        return getTotalTax().add(getSubTotal());

    }

    public String getShippingAddress() {

        return shippingAddress;

    }

    public void setShippingAddress(String shippingAddress) {

        this.shippingAddress = shippingAddress;

    }
}
