package org.enoca.challenge.core.services;

import org.enoca.challenge.core.dtos.requests.IRequestDto;
import org.enoca.challenge.core.dtos.responses.ResponseDto;
import org.enoca.challenge.core.entities.BaseEntity;
import org.enoca.challenge.core.exceptions.EntityNotFoundException;
import org.enoca.challenge.core.mappers.IMapper;
import org.enoca.challenge.core.repositories.BaseRepository;

import java.io.Serializable;
import java.util.List;

public abstract class GenericService<
        RD extends ResponseDto<ID>,
        RQD extends IRequestDto,
        E extends BaseEntity<ID>,
        ID extends Serializable,
        MM extends IMapper<RD, RQD, ID, E>,
        RP extends BaseRepository<ID, E>
        > implements IGenericService<RD, RQD, E, ID>{

    protected final MM mapper;

    protected final RP repository;

    public GenericService(MM mapper, RP repository) {

        this.mapper = mapper;
        this.repository = repository;

    }

    @Override
    public void delete(ID id) {

        var entity  = getOneEntity(id);

        entity.markDeleted();

        repository.save(entity);

    }

    @Override
    public List<RD> getAll() {

        var entityList = repository.findAll();

        return entityList.stream()
                .map(mapper::toResponse)
                .toList();

    }

    @Override
    public List<E> getAllEntities() {

        return repository.findAll();

    }

    @Override
    public RD getOne(ID id) {

        var entity = getOneEntity(id);

        return mapper.toResponse(entity);

    }

    @Override
    public E getOneEntity(ID id) {

        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Entity not found by Id: %s", id)));

    }

    public Boolean existsById(ID id) {

        return repository.existsById(id);

    }
}
