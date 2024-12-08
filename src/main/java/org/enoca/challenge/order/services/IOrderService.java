package org.enoca.challenge.order.services;

import org.enoca.challenge.core.services.IGenericService;
import org.enoca.challenge.order.dtos.response.OrderResponseDto;
import org.enoca.challenge.order.dtos.request.OrderRequestDto;
import org.enoca.challenge.order.dtos.request.OrderRowRequestDto;
import org.enoca.challenge.order.entities.Order;
import org.enoca.challenge.order.mappers.IOrderMapper;

import java.util.List;

public interface IOrderService extends IGenericService<OrderResponseDto, OrderRequestDto, Order, String, IOrderMapper> {

    List<OrderResponseDto> getOrdersByProductId(String id);

    OrderResponseDto addRowToOrder(String id, OrderRowRequestDto orderRowRequestDto);

    OrderResponseDto removeOrderRowFromOrder(String orderId, String orderRowId);


}