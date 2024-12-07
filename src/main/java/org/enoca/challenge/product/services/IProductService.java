package org.enoca.challenge.product.services;

import org.enoca.challenge.core.services.IGenericService;
import org.enoca.challenge.product.dtos.request.ProductRequestDto;
import org.enoca.challenge.product.dtos.response.ProductResponseDto;
import org.enoca.challenge.product.entities.Product;

public interface IProductService extends IGenericService<
        ProductResponseDto,
        ProductRequestDto,
        Product,
        String> {

}
