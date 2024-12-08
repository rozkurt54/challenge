package org.enoca.challenge.product.repositories;

import org.enoca.challenge.core.repositories.BaseRepository;
import org.enoca.challenge.product.entities.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends BaseRepository<String, Product> {
}
