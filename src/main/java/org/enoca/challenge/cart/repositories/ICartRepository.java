package org.enoca.challenge.cart.repositories;

import org.enoca.challenge.cart.entities.Cart;
import org.enoca.challenge.core.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRepository extends BaseRepository<String, Cart> {
}
