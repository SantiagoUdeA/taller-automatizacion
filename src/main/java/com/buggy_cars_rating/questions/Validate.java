package com.buggy_cars_rating.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class Validate implements Question<Boolean> {

    private final String says;
    private final Target target;

    public Validate(Target target, String expectedMessage) {
        this.says = expectedMessage;
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).getText().contains(says);
    }

    public static ValidateBuilder thisTarget(Target target) {
        return Validate.builder().target(target);
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

        public Validate says(String says) {
            this.says = says;
            return new Validate(this.target, this.says);
        }
    }
}
