package org.enoca.challenge.entities.concretes.order;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.enoca.challenge.entities.abstracts.AbstractBaseEntity;
import org.enoca.challenge.entities.concretes.customer.Customer;

import java.time.Instant;
import java.util.List;

@Entity
public class Order extends AbstractBaseEntity<String> {

    @ManyToOne
    private Customer customer;

    private Instant orderDate;

    @OneToMany
    private List<OrderRow> orderRows;

}
