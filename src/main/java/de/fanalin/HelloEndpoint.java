package de.fanalin;

import de.fanalin.entity.Greet;
import de.fanalin.entity.GreetRequest;
import de.fanalin.entity.Greeter;
import de.fanalin.thymeleaf.HtmlResponse;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by matti on 08.05.2016.
 */
@Path("greet")
@Stateless
public class HelloEndpoint {
    @Inject
    private Greeter greeter;

    @GET
    @Produces(MediaType.TEXT_HTML + "; charset=UTF-8")
    public HtmlResponse requestNameAction() {

        return new HtmlResponse("request_name");
    }

    @POST
    @Produces(MediaType.TEXT_HTML + "; charset=UTF-8")
    public HtmlResponse sayHelloAction(@FormParam("name") String name) {

        GreetRequest greetRequest = new GreetRequest(name);

        Greet greet = greeter.sayHello(greetRequest);

        return new HtmlResponse("greet")
                .add("greet", greet);
    }
}
