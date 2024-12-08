package org.enoca.challenge.order.services;

import org.enoca.challenge.cart.services.ICartService;
import org.enoca.challenge.core.services.GenericService;
import org.enoca.challenge.order.dtos.response.OrderResponseDto;
import org.enoca.challenge.order.dtos.request.OrderRequestDto;
import org.enoca.challenge.order.dtos.request.OrderRowRequestDto;
import org.enoca.challenge.order.entities.Order;
import org.enoca.challenge.order.mappers.IOrderMapper;
import org.enoca.challenge.order.repositories.IOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderManager extends GenericService<OrderResponseDto, OrderRequestDto, Order, String, IOrderMapper, IOrderRepository> implements IOrderService {

    private final IOrderRowService orderRowService;
    private final ICartService cartService;

    public OrderManager(IOrderMapper mapper, IOrderRepository repository, IOrderRowService orderRowService, ICartService cartService) {
        super(mapper, repository);
        this.orderRowService = orderRowService;
        this.cartService = cartService;
    }

    @Override
    @Transactional
    public OrderResponseDto create(OrderRequestDto requestDto) {

        var entity = mapper.toEntity(requestDto);

        var savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);

    }



    @Override
    @Transactional
    public OrderResponseDto update(String s, OrderRequestDto requestDTO) {

        var savedEntity = getOneEntity(s);

        var newEntity = mapper.toEntity(requestDTO);

        savedEntity.setCustomer(newEntity.getCustomer());
        savedEntity.setOrderDate(newEntity.getOrderDate());

        var updatedEntity = repository.save(savedEntity);

        return mapper.toResponse(updatedEntity);

    }

    @Override
    public List<OrderResponseDto> getOrdersByProductId(String id) {

        var result = repository.findOrdersByProductId(id);

        return result.stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public OrderResponseDto addRowToOrder(String id, OrderRowRequestDto orderRowRequestDto) {

        var order = getOneEntity(id);

        var orderRowList = order.getOrderRows();

        var filteredRow = orderRowList.stream()
                .filter(item -> item.getProduct().getId().equals(orderRowRequestDto.getProductId()))
                .findFirst();

        if (filteredRow.isPresent()) {

            var row = filteredRow.get();

            orderRowService.setQuantity(row.getId(), row.getQuantity() + orderRowRequestDto.getQuantity());

            return mapper.toResponse(order);
        }

        var orderRowResponseDto = orderRowService.create(orderRowRequestDto);

        var orderRow = orderRowService.getOneEntity(orderRowResponseDto.getId());

        order.getOrderRows().add(orderRow);

        var savedOrder = repository.save(order);

        return mapper.toResponse(savedOrder);

    }

    @Transactional
    @Override
    public OrderResponseDto removeOrderRowFromOrder(String orderId, String orderRowId) {

        var order = getOneEntity(orderId);

        order.getOrderRows().removeIf(item -> item.getId().equals(orderRowId));

        orderRowService.delete(orderRowId);

        var savedOrder = repository.save(order);

        return mapper.toResponse(savedOrder);

    }

    @Override
    @Transactional
    public void delete(String s) {

        var order = getOneEntity(s);

        order.getOrderRows().forEach(orderRow -> orderRowService.delete(orderRow.getId()));

        order.markDeleted();

    }
}