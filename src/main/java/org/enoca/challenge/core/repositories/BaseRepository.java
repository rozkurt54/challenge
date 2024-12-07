package org.enoca.challenge.core.repositories;

import org.enoca.challenge.core.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;


public interface BaseRepository <ID extends Serializable, E extends BaseEntity<ID>> extends JpaRepository<E, ID> {

}
