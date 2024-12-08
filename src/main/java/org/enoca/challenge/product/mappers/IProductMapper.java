package org.enoca.challenge.product.mappers;

import org.enoca.challenge.core.mappers.IMapper;
import org.enoca.challenge.product.dtos.request.ProductRequestDto;
import org.enoca.challenge.product.dtos.response.ProductResponseDto;
import org.enoca.challenge.product.entities.Product;


public interface IProductMapper extends IMapper<ProductResponseDto, ProductRequestDto, String, Product> {

}
