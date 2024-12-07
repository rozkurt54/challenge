package org.enoca.challenge.customer.services;

import org.enoca.challenge.core.services.GenericService;
import org.enoca.challenge.customer.dtos.request.CustomerRequestDto;
import org.enoca.challenge.customer.dtos.response.CustomerResponseDto;
import org.enoca.challenge.customer.entities.Customer;
import org.enoca.challenge.customer.mappers.ICustomerMapper;
import org.enoca.challenge.customer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager extends GenericService<CustomerResponseDto, CustomerRequestDto, Customer, String, ICustomerMapper, CustomerRepository> implements ICustomerService {

    public CustomerManager(ICustomerMapper mapper, CustomerRepository repository) {
        super(mapper, repository);
    }

    @Override
    public CustomerResponseDto create(CustomerRequestDto requestDto) {

        var entity = mapper.toEntity(requestDto);

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
