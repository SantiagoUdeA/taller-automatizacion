package com.buggy_cars_rating.tasks;

import com.buggy_cars_rating.interactions.ClickOn;
import com.buggy_cars_rating.interactions.EnterTheValue;
import com.buggy_cars_rating.user_interfaces.CarModelPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class VoteCarModel implements Task {

    private final String comment;

    public VoteCarModel(String comment) {
        this.comment = comment;
    }

    public static VoteCarModel withComment(String comment) {
        return new VoteCarModel(comment);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterTheValue.into(CarModelPage.COMMENT_TEXTAREA, comment),
                ClickOn.element(CarModelPage.VOTE_BUTTON)
        );
    }
}
