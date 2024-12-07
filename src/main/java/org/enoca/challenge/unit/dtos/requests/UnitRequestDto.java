package org.enoca.challenge.unit.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.enoca.challenge.core.dtos.requests.IRequestDto;

public class UnitRequestDto implements IRequestDto {

    @NotBlank(message = "Unit name must not be null or blank")
    private final String name;

    @NotBlank(message = "Unit short name must not be null or blank")
    @Size(max = 3, min = 1, message = "Unit short name must be 1-3 chars length.")
    private final String shortName;

    public UnitRequestDto(String name, String shortName) {
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
