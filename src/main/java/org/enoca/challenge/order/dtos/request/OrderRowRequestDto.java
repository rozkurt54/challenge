package org.enoca.challenge.order.dtos.request;

import org.enoca.challenge.core.dtos.requests.IRequestDto;

public class OrderRowRequestDto implements IRequestDto {

    private final String productId;

    private final Double quantity;

    public OrderRowRequestDto(String productId, Double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public Double getQuantity() {
        return quantity;
    }
}
