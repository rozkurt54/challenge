package org.enoca.challenge.cart.services;

import org.enoca.challenge.cart.dtos.request.CartRowRequestDto;
import org.enoca.challenge.cart.dtos.response.CartRowResponseDto;
import org.enoca.challenge.cart.entities.CartRow;
import org.enoca.challenge.cart.mappers.ICartRowMapper;
import org.enoca.challenge.core.services.IGenericService;

public interface ICartRowService extends IGenericService<CartRowResponseDto, CartRowRequestDto, CartRow, String, ICartRowMapper> {



}
