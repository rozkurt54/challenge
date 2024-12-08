package org.enoca.challenge.order.services;

import org.enoca.challenge.core.services.GenericService;
import org.enoca.challenge.order.dtos.response.OrderRowResponseDto;
import org.enoca.challenge.order.dtos.request.OrderRowRequestDto;
import org.enoca.challenge.order.entities.OrderRow;
import org.enoca.challenge.order.mappers.IOrderRowMapper;
import org.enoca.challenge.order.repositories.IOrderRowRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderRowManager extends GenericService<OrderRowResponseDto, OrderRowRequestDto, OrderRow, String, IOrderRowMapper, IOrderRowRepository> implements IOrderRowService {

    public OrderRowManager(IOrderRowMapper mapper, IOrderRowRepository repository) {
        super(mapper, repository);
    }

    @Override
    public OrderRowResponseDto create(OrderRowRequestDto requestDto) {
        return null;
    }

    @Override
    public OrderRowResponseDto update(String s, OrderRowRequestDto requestDTO) {
        return null;
    }


    @Override
    public OrderRowResponseDto setQuantity(String id, Double quantity) {

        var entity = getOneEntity(id);

        entity.setQuantity(quantity);

        repository.save(entity);

        return  mapper.toResponse(entity);
    }
}
