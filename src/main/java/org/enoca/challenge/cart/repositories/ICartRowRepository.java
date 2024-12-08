package org.enoca.challenge.cart.repositories;

import org.enoca.challenge.cart.entities.CartRow;
import org.enoca.challenge.core.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartRowRepository extends BaseRepository<String, CartRow> {
}
