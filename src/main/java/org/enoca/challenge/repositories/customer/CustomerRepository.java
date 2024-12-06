package org.enoca.challenge.repositories.customer;

import org.enoca.challenge.entities.concretes.customer.Customer;
import org.enoca.challenge.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends BaseRepository<String, Customer> {

}
