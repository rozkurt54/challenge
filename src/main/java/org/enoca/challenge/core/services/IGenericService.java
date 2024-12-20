package org.enoca.challenge.core.services;

import org.enoca.challenge.core.dtos.requests.IRequestDto;
import org.enoca.challenge.core.dtos.responses.ResponseDto;
import org.enoca.challenge.core.entities.BaseEntity;
import org.enoca.challenge.core.mappers.IMapper;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<
        RD extends ResponseDto<ID>,
        RQD extends IRequestDto,
        E extends BaseEntity<ID>,
        ID extends Serializable,
        MM extends IMapper<RD, RQD, ID, E>
        > {

    List<RD> getAll();

    List<E> getAllEntities();

    RD getOne(ID id);

    E getOneEntity(ID id);

    RD create(RQD requestDto);

    RD update(ID id, RQD requestDTO);

    void delete(ID id);

    Boolean existsById(ID id);

    MM getMapper();

}
