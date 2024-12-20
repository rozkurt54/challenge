package org.enoca.challenge.customer.dtos.response;

import org.enoca.challenge.core.dtos.responses.ResponseDto;

import java.math.BigDecimal;
import java.time.Instant;

public class CustomerResponseDto extends ResponseDto<String> {

    private final String name;

    private final BigDecimal totalOrders;

    private final Integer orderCount;

    public CustomerResponseDto(String id, Instant createdAt, Instant editedAt, String name, BigDecimal totalOrders, Integer orderCount) {

        super(id, createdAt, editedAt);
        this.name = name;
        this.totalOrders = totalOrders;
        this.orderCount = orderCount;

    }

    public String getName() {

        return name;

    }

    public BigDecimal getTotalOrders() {

        return totalOrders;

    }

    public Integer getOrderCount() {

        return orderCount;

    }
}
