package com.buggy_cars_rating.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;


public class TableColumnContainsText implements Question<Boolean> {

    private final Target target;
    private final String expected;

    public TableColumnContainsText(Target target, String expected) {
        this.target = target;
        this.expected = expected;
    }

    public static TableColumnContainsText in(Target target, String expected) {
        return new TableColumnContainsText(target, expected);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveAllFor(actor)
                .stream()
                .anyMatch(el -> el.getText().trim().equalsIgnoreCase(expected));
    }
}
