package de.fanalin.thymeleaf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by matti on 09.05.2016.
 */
public class HtmlResponse {

    public String templateName;
    public Map<String, Object> model = new HashMap<>();

    public HtmlResponse(String templateName) {
        this.templateName = templateName;
    }

    public HtmlResponse add(String modelName, Object model) {
        this.model.put(modelName, model);
        return this;
    }
}
