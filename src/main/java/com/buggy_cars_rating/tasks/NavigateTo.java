package com.buggy_cars_rating.tasks;

import com.buggy_cars_rating.interactions.ClickOn;
import com.buggy_cars_rating.user_interfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class NavigateTo implements Task {

    public static NavigateTo theMostPopularCar(){
        return instrumented(NavigateTo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickOn.element(HomePage.MOST_POPULAR_CAR_LINK)
        );
    }
}
