package org.enoca.challenge.order.dtos.request;

import org.enoca.challenge.core.dtos.requests.IRequestDto;

public class OrderRequestDto implements IRequestDto {


    private final String cartId;

    private final String shippingAddress;

    public OrderRequestDto(String cartId, String shippingAddress) {
        this.cartId = cartId;
        this.shippingAddress = shippingAddress;
    }

    public String getCartId() {
        return cartId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
}
