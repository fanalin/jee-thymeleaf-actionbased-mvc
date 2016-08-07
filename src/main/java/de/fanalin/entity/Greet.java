package de.fanalin.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by matti on 08.05.2016.
 */
@Entity
public class Greet {

    private String greet;

    @Id
    private String name;

    public Greet(String greet, String name) {
        this.greet = greet;
        this.name = name;
    }

    protected Greet() {
    }

    public String getGreet() {
        return greet;
    }

    public String getName() {
        return name;
    }
}
