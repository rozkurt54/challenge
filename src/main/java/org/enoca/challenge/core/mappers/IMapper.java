package org.enoca.challenge.core.mappers;

import jakarta.persistence.MappedSuperclass;
import org.enoca.challenge.core.dtos.requests.IRequestDto;
import org.enoca.challenge.core.dtos.responses.ResponseDto;
import org.enoca.challenge.core.entities.BaseEntity;
import org.mapstruct.Mapping;

import java.io.Serializable;

@MappedSuperclass
public interface IMapper<RD extends ResponseDto<ID>, RQD extends IRequestDto, ID extends Serializable, E extends BaseEntity<ID>> {


    RD toResponse(E entity);

    E toEntity(RQD requestDto);

}
