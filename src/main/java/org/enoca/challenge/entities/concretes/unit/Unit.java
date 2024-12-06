package org.enoca.challenge.entities.concretes.unit;

import jakarta.persistence.Entity;
import org.enoca.challenge.entities.abstracts.AbstractBaseEntity;

@Entity
public class Unit extends AbstractBaseEntity<String> {

    private String name;

    private String shortName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
