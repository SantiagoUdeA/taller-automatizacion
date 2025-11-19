package com.buggy_cars_rating.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;


/*
 * Question que válida si un elemento web contiene un mensaje esperado.
 */
public class Element implements Question<Boolean> {

    private final String says;
    private final Target target;

    public Element(Target target, String expectedMessage) {
        this.says = expectedMessage;
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).getText().contains(says);
    }

    public static ValidateBuilder withTarget(Target target) {
        return Element.builder().target(target);
    }

    private static ValidateBuilder builder() {
        return new ValidateBuilder();
    }

    public static class ValidateBuilder {
        private Target target;
        private String says;

        public ValidateBuilder target(Target target) {
            this.target = target;
            return this;
        }

        public Element says(String says) {
            this.says = says;
            return new Element(this.target, this.says);
        }


    }
}
