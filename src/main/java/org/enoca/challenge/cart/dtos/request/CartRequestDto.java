package org.enoca.challenge.cart.dtos.request;

import org.enoca.challenge.core.dtos.requests.IRequestDto;

import java.util.List;

public class CartRequestDto implements IRequestDto {

    private final String customerId;

    private final List<CartRowRequestDto> cartRowRequestDtos;

    public CartRequestDto(String customerId, List<CartRowRequestDto> cartRowRequestDtos) {

        this.customerId = customerId;
        this.cartRowRequestDtos = cartRowRequestDtos;

    }

    public String getCustomerId() {

        return customerId;

    }

    public List<CartRowRequestDto> getCartRowRequestDtos() {

        return cartRowRequestDtos;

    }
}
