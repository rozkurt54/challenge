package org.enoca.challenge.order.repositories;

import org.enoca.challenge.core.repositories.BaseRepository;
import org.enoca.challenge.order.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends BaseRepository<String, Order> {

    @Query("Select o FROM Order o join o.orderRows orr Where orr.product.id = :productId")
    List<Order> findOrdersByProductId(@Param("productId") String productId);

}
