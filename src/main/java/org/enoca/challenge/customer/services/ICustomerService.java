package org.enoca.challenge.customer.services;

import org.enoca.challenge.core.services.GenericService;
import org.enoca.challenge.core.services.IGenericService;
import org.enoca.challenge.customer.dtos.request.CustomerRequestDto;
import org.enoca.challenge.customer.dtos.response.CustomerResponseDto;
import org.enoca.challenge.customer.entities.Customer;
import org.enoca.challenge.customer.mappers.ICustomerMapper;
import org.enoca.challenge.customer.repositories.CustomerRepository;

public interface ICustomerService extends IGenericService<CustomerResponseDto, CustomerRequestDto, Customer, String> {
}
