package de.fanalin.entity;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by matti on 08.05.2016.
 */
@Stateless
public class GreetFactory {

    private List<String> greets;

    public GreetFactory() {
        greets = new ArrayList<>();
        greets.add("Willkommen");
        greets.add("Hallöchen");
        greets.add("Welcome");
        greets.add("Bonjour");
        greets.add("Huomenta");
    }

    public Greet get(String name) {
        Collections.shuffle(greets);
        return new Greet(greets.get(0), name);
    }
}
