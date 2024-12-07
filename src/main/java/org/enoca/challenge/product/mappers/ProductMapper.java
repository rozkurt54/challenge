package org.enoca.challenge.product.mappers;

import org.enoca.challenge.product.dtos.request.ProductRequestDto;
import org.enoca.challenge.product.dtos.response.ProductResponseDto;
import org.enoca.challenge.product.entities.Product;
import org.enoca.challenge.unit.mappers.IUnitMapper;
import org.enoca.challenge.unit.services.IUnitService;

public class ProductMapper implements IProductMapper {

    private final IUnitService iUnitService;

    private final IUnitMapper iUnitMapper;

    public ProductMapper(IUnitService iUnitService, IUnitMapper iUnitMapper) {
        this.iUnitService = iUnitService;
        this.iUnitMapper = iUnitMapper;
    }

    @Override
    public ProductResponseDto toResponse(Product entity) {
        return new ProductResponseDto(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getEditedAt(),
                entity.getName(),
                iUnitMapper.toResponse(entity.getUnit()),
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
        entity.setStockQuantity(requestDto.getStockQuantity());
        entity.setTaxRate(requestDto.getTaxRate());
        entity.setCurrentPrice(requestDto.getCurrentPrice());

        return entity;
    }
}
