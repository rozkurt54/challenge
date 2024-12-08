package org.enoca.challenge.customer.services;

import org.enoca.challenge.cart.services.ICartService;
import org.enoca.challenge.core.services.GenericService;
import org.enoca.challenge.customer.dtos.request.CustomerRequestDto;
import org.enoca.challenge.customer.dtos.response.CustomerResponseDto;
import org.enoca.challenge.customer.entities.Customer;
import org.enoca.challenge.customer.mappers.ICustomerMapper;
import org.enoca.challenge.customer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager extends GenericService<CustomerResponseDto, CustomerRequestDto, Customer, String, ICustomerMapper, CustomerRepository> implements ICustomerService {

    private final ICartService cartService;

    public CustomerManager(ICustomerMapper mapper, CustomerRepository repository, ICartService cartService) {
        super(mapper, repository);
        this.cartService = cartService;
    }

    @Override
    public CustomerResponseDto create(CustomerRequestDto requestDto) {

        var entity = mapper.toEntity(requestDto);

        var cart = cartService.createCart();

        entity.setCart(cart);

        var savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    @Override
    public CustomerResponseDto update(String s, CustomerRequestDto requestDTO) {

        var entity = getOneEntity(s);

        entity.setName(requestDTO.getName());

        var updatedEntity = repository.save(entity);

        return mapper.toResponse(updatedEntity);

    }
}
