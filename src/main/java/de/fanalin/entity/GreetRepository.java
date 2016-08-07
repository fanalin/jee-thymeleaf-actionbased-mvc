package de.fanalin.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by matti on 08.05.2016.
 */
@Stateless
public class GreetRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Greet findByName(String name) {
        return entityManager.find(Greet.class, name);
    }

    public void add(Greet greet) {
        entityManager.persist(greet);
    }
}
