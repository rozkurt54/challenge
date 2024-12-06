package org.enoca.challenge.repositories.base;

import org.enoca.challenge.entities.abstracts.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;


public interface BaseRepository <ID extends Serializable, E extends AbstractBaseEntity<ID>> extends JpaRepository<E, ID> {

}
