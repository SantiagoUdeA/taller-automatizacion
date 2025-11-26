package com.courier_sync.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;


/*
 * Question que válida si un elemento web contiene un mensaje esperado.
 */
public class TargetHasMessage implements Question<Boolean> {

    private final String expectedMessage;
    private final Target target;

    public TargetHasMessage(Target target, String expectedMessage) {
        this.expectedMessage = expectedMessage;
        this.target = target;
    }

    public static TargetHasMessage equalTo(String expectedMessage, Target target) {
        return new TargetHasMessage(target, expectedMessage);
    }

    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        String actualMessage = Text.of(target).answeredBy(actor);
        return actualMessage.equals(expectedMessage);
    }
}
