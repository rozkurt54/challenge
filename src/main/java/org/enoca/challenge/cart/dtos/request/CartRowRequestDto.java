package org.enoca.challenge.cart.dtos.request;

import org.enoca.challenge.core.dtos.requests.IRequestDto;

public class CartRowRequestDto implements IRequestDto {

    private final String productId;

    private final Double amount;

    public CartRowRequestDto(String productId, Double amount) {
        this.productId = productId;
        this.amount = amount;
    }

    public String getProductId() {
        return productId;
    }

    public Double getAmount() {
        return amount;
    }
}
