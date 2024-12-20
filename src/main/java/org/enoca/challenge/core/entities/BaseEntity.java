package org.enoca.challenge.core.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements IBaseEntity<ID> {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, updatable = false, length = 36)
    private ID id;

    private Instant createdAt;

    private Instant editedAt;

    private Boolean markedAsDeleted = false;

    public BaseEntity() {

        var instant = Instant.now();
        this.createdAt = instant;
        this.editedAt = instant;

    }

    @Override
    public ID getId() {

        return this.id;

    }

    @Override
    public void setId(ID id) {

        this.id=id;

    }

    @Override
    public Instant getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public Instant getEditedAt() {
        return this.editedAt;
    }

    @Override
    public void setEditedAt(Instant instant) {
        this.editedAt = instant;
    }

    @Override
    public Boolean getDeleted() {
        return markedAsDeleted;
    }

    @Override
    public void markDeleted() {
        this.markedAsDeleted = true;
        this.setEditedAt(Instant.now());
    }

    @Override
    public void markUndeleted() {
        this.markedAsDeleted = false;
        this.setEditedAt(Instant.now());
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
