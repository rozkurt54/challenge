package org.enoca.challenge.product.mappers;

import org.enoca.challenge.product.dtos.request.ProductRequestDto;
import org.enoca.challenge.product.dtos.response.ProductResponseDto;
import org.enoca.challenge.product.entities.Product;
import org.enoca.challenge.unit.mappers.IUnitMapper;
import org.enoca.challenge.unit.services.IUnitService;

public class ProductMapper implements IProductMapper {

    private final IUnitService iUnitService;


    public ProductMapper(IUnitService iUnitService) {
        this.iUnitService = iUnitService;

    }

    @Override
    public ProductResponseDto toResponse(Product entity) {

        var unitResponseDto = iUnitService.getOne(entity.getUnit().getId());

        return new ProductResponseDto(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getEditedAt(),
                entity.getName(),
                unitResponseDto,
                entity.getTaxRate(),
                entity.getCurrentPrice(),
                entity.getStockQuantity()
        );
    }

    @Override
    public Product toEntity(ProductRequestDto requestDto) {

        var entity = new Product();

        entity.setName(requestDto.getName());
        entity.setUnit(iUnitService.getOneEntity(requestDto.getUnitId()));
        entity.setStockQuantity(requestDto.getStockAmount());
        entity.setTaxRate(requestDto.getTaxRate());
        entity.setCurrentPrice(requestDto.getCurrentPrice());

        return entity;
    }
}
