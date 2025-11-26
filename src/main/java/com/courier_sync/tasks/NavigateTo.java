package com.courier_sync.tasks;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

/*
 * Task que permite abrir una página web especificada como un PageObject.
 */
public class NavigateTo implements Task {

    private final PageObject page;

    public NavigateTo(PageObject page){
        this.page = page;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(page));
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static NavigateTo page(PageObject page) {
        return Tasks.instrumented(NavigateTo.class, page);
    }
}
