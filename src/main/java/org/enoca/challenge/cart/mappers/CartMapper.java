package org.enoca.challenge.cart.mappers;

import org.enoca.challenge.cart.dtos.request.CartRequestDto;
import org.enoca.challenge.cart.dtos.response.CartResponseDto;
import org.enoca.challenge.cart.entities.Cart;
import org.enoca.challenge.cart.entities.CartRow;
import org.enoca.challenge.cart.services.ICartRowService;

import java.math.BigDecimal;

public class CartMapper implements ICartMapper {

    private final ICartRowService cartRowService;


    public CartMapper(ICartRowService cartRowService) {

        this.cartRowService = cartRowService;
    }

    @Override
    public CartResponseDto toResponse(Cart entity) {


        var cartRowResponseDtos = entity.getCartRows()
                .stream()
                .map(item -> cartRowService.getMapper().toResponse(item))
                .toList();

        var taxTotal = BigDecimal.ZERO;
        var subTotal = BigDecimal.ZERO;
        var grandTotal = BigDecimal.ZERO;

        if (!entity.getCartRows().isEmpty()) {

            for (CartRow cartRow : entity.getCartRows()) {

                if (cartRow.getRowTax().compareTo(BigDecimal.ZERO) > 0) {

                    taxTotal = taxTotal.add(cartRow.getRowTax());

                }

                if (cartRow.getRowSum().compareTo(BigDecimal.ZERO) > 0) {

                    subTotal = subTotal.add(cartRow.getRowSum());

                }

                if (cartRow.getRowTotal().compareTo(BigDecimal.ZERO) > 0) {

                    grandTotal = grandTotal.add(cartRow.getRowTotal());

                }

            }

        }

        return new CartResponseDto(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getEditedAt(),
                cartRowResponseDtos,
                cartRowResponseDtos.size(),
                taxTotal,
                subTotal,
                grandTotal
                );
}

@Override
public Cart toEntity(CartRequestDto requestDto) {

        var entity = new Cart();

        var cartRowRequestDtoList = requestDto
                .getCartRowRequestDtos()
                .stream()
                .map(cartRowService::create)
                .toList();

        var cartRowList = cartRowRequestDtoList
                .stream()
                .map(item -> cartRowService.getOneEntity(item.getId()))
                .toList();

        entity.setCartRows(cartRowList);


    return entity;
}
}
