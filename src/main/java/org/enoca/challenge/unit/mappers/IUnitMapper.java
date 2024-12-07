package org.enoca.challenge.unit.mappers;

import org.enoca.challenge.core.mappers.IMapper;
import org.enoca.challenge.unit.dtos.requests.UnitRequestDto;
import org.enoca.challenge.unit.dtos.responses.UnitResponseDto;
import org.enoca.challenge.unit.entities.Unit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUnitMapper extends IMapper<UnitResponseDto, UnitRequestDto, String, Unit> {

    @Override
    UnitResponseDto toResponse(Unit entity);

    @Override
    @Mapping(source = "name", target = "name")
    @Mapping(source = "shortName", target = "shortName")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Unit toEntity(UnitRequestDto RequestDto);

}
