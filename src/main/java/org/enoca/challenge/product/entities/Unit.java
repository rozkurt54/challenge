package org.enoca.challenge.product.entities;

import jakarta.persistence.Entity;
import org.enoca.challenge.core.entities.BaseEntity;

@Entity
public class Unit extends BaseEntity<String> {

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
