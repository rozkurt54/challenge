package org.enoca.challenge.cart.mappers;

import org.enoca.challenge.cart.dtos.request.CartRowRequestDto;
import org.enoca.challenge.cart.dtos.response.CartRowResponseDto;
import org.enoca.challenge.cart.entities.CartRow;
import org.enoca.challenge.core.mappers.IMapper;



public interface ICartRowMapper extends IMapper<CartRowResponseDto, CartRowRequestDto, String, CartRow> {

    @Override
    CartRowResponseDto toResponse(CartRow entity);

    @Override
    CartRow toEntity(CartRowRequestDto RequestDto);
}
