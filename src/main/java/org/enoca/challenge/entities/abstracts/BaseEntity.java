package org.enoca.challenge.entities.abstracts;


import java.io.Serializable;
import java.time.Instant;


public interface BaseEntity<ID extends Serializable> {

    ID getId();

    void  setId(ID id);

    Instant getCreatedAt();

    Instant getEditedAt();

    void  setEditedAt(Instant instant);

    Boolean getDeleted();

    void markDeleted();

    void markUndeleted();

}
