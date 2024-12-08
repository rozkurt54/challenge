package org.enoca.challenge.cart.mappers;

import org.enoca.challenge.cart.dtos.request.CartRowRequestDto;
import org.enoca.challenge.cart.dtos.response.CartRowResponseDto;
import org.enoca.challenge.cart.entities.CartRow;
import org.enoca.challenge.product.services.IProductService;

public class CartRowMapper implements ICartRowMapper {


    private final IProductService productService;

    public CartRowMapper(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public CartRowResponseDto toResponse(CartRow entity) {


        return new CartRowResponseDto(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getEditedAt(),
                entity.getProduct(),
                entity.getQuantity(),
                entity.getUnitPrice(),
                entity.getRowTotal(),
                entity.getUnit()
        );
    }

    @Override
    public CartRow toEntity(CartRowRequestDto cartRowRequestDto) {

        var row = new CartRow();

        var product = productService.getOneEntity(cartRowRequestDto.getProductId());

        row.setProduct(product);
        row.setQuantity(cartRowRequestDto.getAmount());
        row.setUnitPrice(product.getCurrentPrice());
        row.setUnit(product.getUnit());

        return row;
    }
}
