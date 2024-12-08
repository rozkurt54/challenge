package org.enoca.challenge.cart.mappers;

import org.enoca.challenge.cart.dtos.request.CartRequestDto;
import org.enoca.challenge.cart.dtos.response.CartResponseDto;
import org.enoca.challenge.cart.entities.Cart;
import org.enoca.challenge.core.mappers.IMapper;

public interface ICartMapper extends IMapper<CartResponseDto, CartRequestDto, String, Cart> {

    @Override
    CartResponseDto toResponse(Cart entity);

    @Override
    Cart toEntity(CartRequestDto RequestDto);

}

