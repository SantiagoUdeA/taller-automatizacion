package com.buggy_cars_rating.tasks;

import com.buggy_cars_rating.interactions.ClickOn;
import com.buggy_cars_rating.interactions.EnterTheValue;
import com.buggy_cars_rating.user_interfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class FillLoginForm implements Task {

    private final String username;
    private final String password;

    public FillLoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static FillLoginForm withData(String username, String password) {
        return new FillLoginForm(username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterTheValue.into(HomePage.USERNAME_INPUT, username),
                EnterTheValue.into(HomePage.PASSWORD_INPUT, password),
                ClickOn.element(HomePage.LOGIN_BUTTON)
        );
    }

}
