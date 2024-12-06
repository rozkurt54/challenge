package org.enoca.challenge.entities.concretes.customer;

import jakarta.persistence.Entity;
import org.enoca.challenge.entities.abstracts.AbstractBaseEntity;

@Entity
public class Customer extends AbstractBaseEntity<String> {

    private String name;

}
