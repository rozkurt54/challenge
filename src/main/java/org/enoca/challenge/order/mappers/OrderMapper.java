package org.enoca.challenge.order.mappers;

import org.enoca.challenge.cart.entities.CartRow;
import org.enoca.challenge.cart.services.ICartRowService;
import org.enoca.challenge.cart.services.ICartService;
import org.enoca.challenge.order.dtos.request.OrderRequestDto;
import org.enoca.challenge.order.dtos.request.OrderRowRequestDto;
import org.enoca.challenge.order.dtos.response.OrderResponseDto;
import org.enoca.challenge.order.entities.Order;
import org.enoca.challenge.order.services.IOrderRowService;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class OrderMapper implements IOrderMapper {

    private final IOrderRowService orderRowService;
    private final ICartService cartService;
    private final ICartRowService cartRowService;

    public OrderMapper(IOrderRowService orderRowService, ICartService cartService, ICartRowService cartRowService) {
        this.orderRowService = orderRowService;
        this.cartService = cartService;
        this.cartRowService = cartRowService;
    }

    @Override
    public OrderResponseDto toResponse(Order entity) {

        Map<String, String> customer = new HashMap<>();

        customer.put("customerId", entity.getCustomer().getId());
        customer.put("customerName", entity.getCustomer().getName());


        var orderRowResponseList = entity.getOrderRows()
                .stream()
                .map(orderRow -> orderRowService.getMapper().toResponse(orderRow))
                .toList();

        return new OrderResponseDto(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getEditedAt(),
                customer,
                entity.getShippingAddress(),
                orderRowResponseList,
                entity.getTotalTax(),
                entity.getSubTotal(),
                entity.getGrandTotal()
        );
    }

    @Override
    public Order toEntity(OrderRequestDto requestDto) {

        var cart = cartService.getOneEntity(requestDto.getCartId());

        var customer = cart.getCustomer();

        var cartRows = cart.getCartRows();

        var orderRowResponseList = cartRows
                .stream()
                .map(item -> orderRowService.create(convertCartRowToOrderRow(item)))
                .toList();

        var orderRowList = orderRowResponseList.stream().map(item -> orderRowService.getOneEntity(item.getId())).toList();

        var order = new Order();

        order.setOrderRows(orderRowList);

        order.setCustomer(customer);

        order.setOrderDate(Instant.now());

        order.setShippingAddress(requestDto.getShippingAddress());

        return order;

    }

    private OrderRowRequestDto convertCartRowToOrderRow(CartRow cartRow) {

        return new OrderRowRequestDto(cartRow.getProduct().getId(), cartRow.getQuantity());
    }
}
