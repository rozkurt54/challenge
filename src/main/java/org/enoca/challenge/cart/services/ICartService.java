package org.enoca.challenge.cart.services;

import org.enoca.challenge.cart.dtos.request.CartRequestDto;
import org.enoca.challenge.cart.dtos.request.CartRowRequestDto;
import org.enoca.challenge.cart.dtos.response.CartResponseDto;
import org.enoca.challenge.cart.entities.Cart;
import org.enoca.challenge.cart.mappers.ICartMapper;
import org.enoca.challenge.core.services.IGenericService;

public interface ICartService extends IGenericService<CartResponseDto, CartRequestDto, Cart, String, ICartMapper> {

    Cart createCart();

    CartResponseDto addProductToCart(String cartId, CartRowRequestDto cartRowRequestDto);

    CartResponseDto emptyCart(String id);

    CartResponseDto updateCartRow(String cartId, String rowId, CartRowRequestDto cartRowRequestDto);




}
