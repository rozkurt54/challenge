package org.enoca.challenge.unit.repositories;


import org.enoca.challenge.core.repositories.BaseRepository;
import org.enoca.challenge.unit.entities.Unit;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnitRepository extends BaseRepository<String, Unit> {

}
