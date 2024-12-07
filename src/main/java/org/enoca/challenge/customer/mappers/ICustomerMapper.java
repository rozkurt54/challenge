package org.enoca.challenge.customer.mappers;

import org.enoca.challenge.core.mappers.IMapper;
import org.enoca.challenge.customer.dtos.request.CustomerRequestDto;
import org.enoca.challenge.customer.dtos.response.CustomerResponseDto;
import org.enoca.challenge.customer.entities.Customer;
import org.mapstruct.Mapper;


@Mapper(componentModel = "string")
public interface ICustomerMapper extends IMapper<CustomerResponseDto, CustomerRequestDto, String, Customer> {

    @Override
    CustomerResponseDto toResponse(Customer entity);

    @Override
    Customer toEntity(CustomerRequestDto RequestDto);
}
