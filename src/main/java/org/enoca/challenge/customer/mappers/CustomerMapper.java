package org.enoca.challenge.customer.mappers;

import org.enoca.challenge.cart.services.ICartService;
import org.enoca.challenge.customer.dtos.request.CustomerRequestDto;
import org.enoca.challenge.customer.dtos.response.CustomerResponseDto;
import org.enoca.challenge.customer.entities.Customer;
import org.enoca.challenge.order.entities.Order;

import java.math.BigDecimal;
import java.util.Objects;

public class CustomerMapper implements ICustomerMapper{



    @Override
    public CustomerResponseDto toResponse(Customer entity) {

        var totalOrder = BigDecimal.ZERO;

        if(Objects.nonNull(entity.getOrders()) && !entity.getOrders().isEmpty()) {
            for (Order order : entity.getOrders()) {
                totalOrder = totalOrder.add(order.getGrandTotal());
            }
        }

        return new CustomerResponseDto(
                entity.getId(),
                entity.getCreatedAt(),
                entity.getEditedAt(),
                entity.getName(),
                totalOrder,
                entity.getOrders().size()
        );
    }

    @Override
    public Customer toEntity(CustomerRequestDto requestDto) {

        var customer = new Customer();

        customer.setName(requestDto.getName());

        return customer;

    }
}
