package org.enoca.challenge.unit.dtos.responses;

import org.enoca.challenge.core.dtos.responses.ResponseDto;

import java.time.Instant;

public class UnitResponseDto extends ResponseDto<String> {


    private final String name;

    private final String shortName;

    public UnitResponseDto(String id,
                           Instant createdAt,
                           Instant editedAt,
                           String name,
                           String shortName) {

        super(id, createdAt, editedAt);
        this.name = name;
        this.shortName = shortName;

    }

    public String getName() {

        return name;

    }

    public String getShortName() {

        return shortName;

    }
}
