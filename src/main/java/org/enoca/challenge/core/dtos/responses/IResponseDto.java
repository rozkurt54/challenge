package org.enoca.challenge.core.dtos.responses;

import java.io.Serializable;
import java.time.Instant;

public interface IResponseDto<ID extends Serializable> {

    ID getId();

    Instant getCreatedAt();

    Instant getEditedAt();

}
