package com.buggy_cars_rating.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class IsVisible implements Question<Boolean> {

    private final Target target;

    public IsVisible(Target target) {
        this.target = target;
    }

    public static IsVisible element(Target target) {
        return new IsVisible(target);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).isVisible();
    }
}
