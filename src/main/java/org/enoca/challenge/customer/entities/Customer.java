package org.enoca.challenge.customer.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import org.enoca.challenge.core.entities.BaseEntity;
import org.enoca.challenge.chart.entities.Chart;
import org.enoca.challenge.order.entities.Order;

import java.util.List;

@Entity
public class Customer extends BaseEntity<String> {

    private String name;

    @OneToMany
    private List<Order> orders;

    @OneToOne
    private Chart chart;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }
}
