package org.enoca.challenge.order.mappers;

import org.enoca.challenge.order.dtos.request.OrderRowRequestDto;
import org.enoca.challenge.order.dtos.response.OrderRowResponseDto;
import org.enoca.challenge.order.entities.OrderRow;
import org.enoca.challenge.product.services.IProductService;

import java.util.HashMap;
import java.util.Map;

public class OrderRowMapper implements IOrderRowMapper {


    private final IProductService productService;

    public OrderRowMapper(IProductService productService) {
        this.productService = productService;
    }

    @Override
    public OrderRowResponseDto toResponse(OrderRow entity) {

        var product = entity.getProduct();

        Map<String, String> productMap = new HashMap<>();

        productMap.put("productId", product.getId());
        productMap.put("productName", product.getName());

        Map<String, String> unitMap = new HashMap<>();
        unitMap.put("unitId", entity.getProduct().getUnit().getId());
        unitMap.put("unitName", entity.getProduct().getUnit().getName());
        unitMap.put("unitShortName", entity.getProduct().getUnit().getShortName());

        return new OrderRowResponseDto(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getEditedAt(),
                entity.getOrder().getId(),
                productMap,
                unitMap,
                entity.getQuantity(),
                entity.getUnitPrice(),
                entity.getRowTax(),
                entity.getRowSum(),
                entity.getRowTotal()
        );
    }

    @Override
    public OrderRow toEntity(OrderRowRequestDto requestDto) {

        var product = productService.getOneEntity(requestDto.getProductId());

        var orderRow = new OrderRow();
        orderRow.setProduct(product);
        orderRow.setQuantity(requestDto.getQuantity());
        orderRow.setUnitPrice(orderRow.getProduct().getCurrentPrice());

        return orderRow;

    }
}
