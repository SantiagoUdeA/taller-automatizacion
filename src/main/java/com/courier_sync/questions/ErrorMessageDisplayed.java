package com.courier_sync.questions;

import com.courier_sync.user_interfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ErrorMessageDisplayed implements Question<String> {

    public static ErrorMessageDisplayed text() {
        return new ErrorMessageDisplayed();
    }

    @Override
    public String answeredBy(Actor actor) {
        return LoginPage.ERROR_MESSAGE.resolveFor(actor).getText();
    }
}
