package org.enoca.challenge.order.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.enoca.challenge.core.entities.BaseEntity;
import org.enoca.challenge.customer.entities.Customer;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "orders") // The word order is a reserved keyword for mysql.
public class Order extends BaseEntity<String> {

    @ManyToOne
    private Customer customer;

    private Instant orderDate;

    @OneToMany(orphanRemoval = true)
    private List<OrderRow> orderRows;

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
        return orderRows;
    }

    public void setOrderRows(List<OrderRow> orderRows) {
        this.orderRows = orderRows;
    }
}
