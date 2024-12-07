package org.enoca.challenge.unit.services;

import org.enoca.challenge.core.services.IGenericService;
import org.enoca.challenge.unit.Dtos.requests.UnitRequestDto;
import org.enoca.challenge.unit.Dtos.responses.UnitResponseDto;
import org.enoca.challenge.unit.entities.Unit;

public interface IUnitService extends IGenericService<UnitResponseDto, UnitRequestDto, Unit, String> {
}