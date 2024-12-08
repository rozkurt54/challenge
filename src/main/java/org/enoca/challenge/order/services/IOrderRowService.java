package org.enoca.challenge.order.services;

import org.enoca.challenge.core.services.IGenericService;
import org.enoca.challenge.order.dtos.response.OrderRowResponseDto;
import org.enoca.challenge.order.dtos.request.OrderRowRequestDto;
import org.enoca.challenge.order.entities.OrderRow;
import org.enoca.challenge.order.mappers.IOrderRowMapper;

public interface IOrderRowService extends IGenericService<OrderRowResponseDto, OrderRowRequestDto, OrderRow, String, IOrderRowMapper> {

    OrderRowResponseDto setQuantity(String id, Double quantity);

}
