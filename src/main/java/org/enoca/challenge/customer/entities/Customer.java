package org.enoca.challenge.customer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.enoca.challenge.core.entities.BaseEntity;
import org.enoca.challenge.cart.entities.Cart;
import org.enoca.challenge.order.entities.Order;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends BaseEntity<String> {

    private String name;

    @OneToMany
    private List<Order> orders = new ArrayList<>();

    @OneToOne
    private Cart cart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {

        if(orders == null) {
            setOrders(new ArrayList<>());
        }

        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
