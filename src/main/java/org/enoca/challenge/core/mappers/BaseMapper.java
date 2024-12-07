package org.enoca.challenge.core.mappers;

import org.enoca.challenge.core.dtos.requests.IRequestDto;
import org.enoca.challenge.core.dtos.responses.ResponseDto;
import org.enoca.challenge.core.entities.BaseEntity;

import java.io.Serializable;

public interface BaseMapper<RD extends ResponseDto<ID>, RQD extends IRequestDto, ID extends Serializable, E extends BaseEntity<ID>> {

    RD toResponse(E entity);

    E toEntity(RQD RequestDto);

}
