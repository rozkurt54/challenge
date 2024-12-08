package org.enoca.challenge.cart.services;

import org.enoca.challenge.cart.dtos.request.CartRowRequestDto;
import org.enoca.challenge.cart.dtos.response.CartRowResponseDto;
import org.enoca.challenge.cart.entities.CartRow;
import org.enoca.challenge.cart.mappers.ICartRowMapper;
import org.enoca.challenge.cart.repositories.ICartRowRepository;
import org.enoca.challenge.core.services.GenericService;
import org.springframework.stereotype.Service;


@Service
public class CartRowManager extends GenericService<CartRowResponseDto, CartRowRequestDto, CartRow, String, ICartRowMapper, ICartRowRepository> implements ICartRowService {

    public CartRowManager(ICartRowMapper mapper, ICartRowRepository repository) {

        super(mapper, repository);

    }

    @Override
    public CartRowResponseDto create(CartRowRequestDto requestDto) {

        var entity = mapper.toEntity(requestDto);

        var savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);

    }

    @Override
    public CartRowResponseDto update(String s, CartRowRequestDto requestDTO) {

        var newEntity = mapper.toEntity(requestDTO);

        var existedEntity = getOneEntity(s);

        existedEntity.setUnit(newEntity.getUnit());
        existedEntity.setProduct(newEntity.getProduct());
        existedEntity.setQuantity(newEntity.getQuantity());
        existedEntity.setUnitPrice(newEntity.getUnitPrice());

        var updatedEntity = repository.save(existedEntity);


        return mapper.toResponse(updatedEntity);

    }

}
