package org.enoca.challenge.unit.services;

import org.enoca.challenge.core.services.GenericService;
import org.enoca.challenge.unit.exceptions.UnitNameAlreadyExistsException;
import org.enoca.challenge.unit.exceptions.UnitShortNameAlreadyExistsException;
import org.enoca.challenge.unit.repositories.IUnitRepository;
import org.enoca.challenge.unit.Dtos.requests.UnitRequestDto;
import org.enoca.challenge.unit.Dtos.responses.UnitResponseDto;
import org.enoca.challenge.unit.entities.Unit;
import org.enoca.challenge.unit.mappers.IUnitMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UnitManager
        extends GenericService<UnitResponseDto, UnitRequestDto, Unit, String, IUnitMapper, IUnitRepository>
        implements IUnitService {
    public UnitManager(IUnitMapper mapper, IUnitRepository repository) {
        super(mapper, repository);
    }

    @Override
    public UnitResponseDto create(UnitRequestDto requestDto) {

        checkNameOrShortNameExists(requestDto);

        var entity = mapper.toEntity(requestDto);

        var savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);

    }

    @Override
    public UnitResponseDto update(String id, UnitRequestDto requestDTO) {

        var entity = getOneEntity(id);

        entity.setName(requestDTO.getName());
        entity.setShortName(requestDTO.getShortName());
        entity.setEditedAt(Instant.now());

        var savedEntity = repository.save(entity);

        return mapper.toResponse(savedEntity);
    }

    private void checkNameOrShortNameExists(UnitRequestDto unitRequestDto) {

        checkNameAlreadyExists(unitRequestDto.getName());
        checkShortNameAlreadyExists(unitRequestDto.getShortName());

    }

    private void checkNameAlreadyExists(String name) {

        if(repository.existsByName(name)) {

            var message = String.format("Given name already exists: %s", name);

            throw new UnitNameAlreadyExistsException();
        }

    }

    private void  checkShortNameAlreadyExists(String shortName) {

        if(repository.existsByShortName(shortName)) {

            var message = String.format("Given shortName already exists %s", shortName);

            throw new UnitShortNameAlreadyExistsException(message);

        }

    }
}
