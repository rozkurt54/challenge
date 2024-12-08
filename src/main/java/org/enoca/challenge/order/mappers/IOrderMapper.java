package org.enoca.challenge.order.mappers;

import org.enoca.challenge.core.mappers.IMapper;
import org.enoca.challenge.order.dtos.request.OrderRequestDto;
import org.enoca.challenge.order.dtos.response.OrderResponseDto;
import org.enoca.challenge.order.entities.Order;

public interface IOrderMapper extends IMapper<OrderResponseDto, OrderRequestDto, String, Order> {

    @Override
    OrderResponseDto toResponse(Order entity);

    @Override
    Order toEntity(OrderRequestDto requestDto);
}
