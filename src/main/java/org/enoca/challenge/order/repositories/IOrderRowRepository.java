package org.enoca.challenge.order.repositories;


import org.enoca.challenge.core.repositories.BaseRepository;
import org.enoca.challenge.order.entities.OrderRow;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRowRepository extends BaseRepository<String, OrderRow> {
}
