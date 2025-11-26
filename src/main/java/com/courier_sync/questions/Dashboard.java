package com.courier_sync.questions;

import com.courier_sync.user_interfaces.DashboardPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Dashboard implements Question<Boolean> {

    public static Dashboard isDisplayed() {
        return new Dashboard();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return DashboardPage.DASHBOARD_MAIN.resolveFor(actor).isVisible();
    }
}