package org.enoca.challenge.product.services;

import org.enoca.challenge.core.services.GenericService;
import org.enoca.challenge.product.dtos.request.ProductRequestDto;
import org.enoca.challenge.product.dtos.response.ProductResponseDto;
import org.enoca.challenge.product.entities.Product;
import org.enoca.challenge.product.mappers.IProductMapper;
import org.enoca.challenge.product.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ProductManager
        extends GenericService<ProductResponseDto, ProductRequestDto, Product, String, IProductMapper, IProductRepository>
        implements IProductService {

    public ProductManager(IProductMapper mapper, IProductRepository repository) {
        super(mapper, repository);
    }

    @Override
    public ProductResponseDto create(ProductRequestDto requestDto) {

        var entity = mapper.toEntity(requestDto);

        var savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    @Override
    public ProductResponseDto update(String s, ProductRequestDto requestDTO) {

        var newEntity = mapper.toEntity(requestDTO);

        var entity = getOneEntity(s);

        entity.setCurrentPrice(newEntity.getCurrentPrice());
        entity.setStockQuantity(newEntity.getStockQuantity());
        entity.setName(newEntity.getName());
        entity.setTaxRate(newEntity.getTaxRate());
        entity.setUnit(newEntity.getUnit());
        entity.setEditedAt(Instant.now());

        var savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }
}
