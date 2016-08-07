package de.fanalin.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by matti on 14.05.2016.
 */
public class GreetRequest {
    @NotNull
    @Pattern(regexp = ".+") // poor-mans @NotBlank
    private String name;

    public GreetRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
