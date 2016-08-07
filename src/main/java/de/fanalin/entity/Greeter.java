package de.fanalin.entity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by matti on 08.05.2016.
 */
@Stateless
public class Greeter {

    private GreetRepository greetRepository;

    private GreetFactory greetFactory;

    private static final ValidatorFactory validatorFactory
            = Validation.buildDefaultValidatorFactory();

    @Inject
    public Greeter(GreetRepository greetRepository, GreetFactory greetFactory) {
        this.greetRepository = greetRepository;
        this.greetFactory = greetFactory;
    }

    public Greeter() {
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Greet sayHello(GreetRequest greetRequest) {

        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<GreetRequest>> errors = validator.validate(greetRequest);

        if (errors.size() > 0) {
            throw new IllegalArgumentException();
        }

        Greet greet = greetRepository.findByName(greetRequest.getName());

        if (greet == null) {
            greet = greetFactory.get(greetRequest.getName());
            greetRepository.add(greet);
        }

        return greet;
    }
}
