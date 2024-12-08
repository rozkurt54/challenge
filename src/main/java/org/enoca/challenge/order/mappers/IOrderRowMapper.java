package org.enoca.challenge.order.mappers;

import org.enoca.challenge.core.mappers.IMapper;
import org.enoca.challenge.order.dtos.request.OrderRowRequestDto;
import org.enoca.challenge.order.dtos.response.OrderRowResponseDto;
import org.enoca.challenge.order.entities.OrderRow;


public interface IOrderRowMapper extends IMapper<OrderRowResponseDto, OrderRowRequestDto, String, OrderRow> {

    @Override
    OrderRowResponseDto toResponse(OrderRow entity);

    @Override
    OrderRow toEntity(OrderRowRequestDto requestDto);

}
