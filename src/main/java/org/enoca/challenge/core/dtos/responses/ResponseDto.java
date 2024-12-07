package org.enoca.challenge.core.dtos.responses;

import java.io.Serializable;
import java.time.Instant;

public abstract class ResponseDto<ID extends Serializable> implements IResponseDto<ID> {

    private final ID id;

    private final Instant createdAt;

    private final Instant editedAt;


    public ResponseDto(ID id, Instant createdAt, Instant editedAt) {

        this.id = id;
        this.createdAt = createdAt;
        this.editedAt = editedAt;

    }

    @Override
    public ID getId() {

        return this.id;

    }

    @Override
    public Instant getCreatedAt() {

        return this.createdAt;

    }

    @Override
    public Instant getEditedAt() {

        return editedAt;

    }
}
