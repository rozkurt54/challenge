package org.enoca.challenge.customer.repositories;

import org.enoca.challenge.customer.entities.Customer;
import org.enoca.challenge.core.repositories.BaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends BaseRepository<String, Customer> {

}
