package org.enoca.challenge.core.entities;


import java.io.Serializable;
import java.time.Instant;


public interface IBaseEntity<ID extends Serializable> {

    ID getId();

    void  setId(ID id);

    Instant getCreatedAt();

    Instant getEditedAt();

    void  setEditedAt(Instant instant);

    Boolean getDeleted();

    void markDeleted();

    void markUndeleted();

}
