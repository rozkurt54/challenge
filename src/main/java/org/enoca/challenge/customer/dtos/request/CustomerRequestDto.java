package org.enoca.challenge.customer.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.enoca.challenge.core.dtos.requests.IRequestDto;

public class CustomerRequestDto implements IRequestDto {

    @NotNull
    @NotBlank
    private final String name;

    public CustomerRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
