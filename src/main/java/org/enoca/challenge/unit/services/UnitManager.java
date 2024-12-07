package org.enoca.challenge.unit.services;

import org.enoca.challenge.core.services.GenericService;
import org.enoca.challenge.unit.repositories.IUnitRepository;
import org.enoca.challenge.unit.Dtos.requests.UnitRequestDto;
import org.enoca.challenge.unit.Dtos.responses.UnitResponseDto;
import org.enoca.challenge.unit.entities.Unit;
import org.enoca.challenge.unit.mappers.IUnitMapper;
import org.springframework.stereotype.Service;

@Service
public class UnitManager
        extends GenericService<UnitResponseDto, UnitRequestDto, Unit, String, IUnitMapper, IUnitRepository>
        implements IUnitService {
    public UnitManager(IUnitMapper mapper, IUnitRepository repository) {
        super(mapper, repository);
    }

    @Override
    public UnitResponseDto create(UnitRequestDto requestDto) {
        return null;
    }

    @Override
    public UnitResponseDto update(String s, UnitRequestDto requestDTO) {
        return null;
    }
}
