package com.buggy_cars_rating.tasks;

import com.buggy_cars_rating.interactions.ClickOn;
import com.buggy_cars_rating.interactions.EnterTheValue;
import com.buggy_cars_rating.user_interfaces.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/*
 * Tarea para llenar el formulario de registro y enviarlo.
 */
public class FillRegistrationForm implements Task {

    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;

    public FillRegistrationForm(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public static FillRegistrationForm withData(String username, String first, String last, String password) {
        return instrumented(FillRegistrationForm.class, username, first, last, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EnterTheValue.into(RegisterPage.USERNAME_INPUT, username),
                EnterTheValue.into(RegisterPage.FIRST_NAME_INPUT, firstName),
                EnterTheValue.into(RegisterPage.LAST_NAME_INPUT, lastName),
                EnterTheValue.into(RegisterPage.PASSWORD_INPUT, password),
                EnterTheValue.into(RegisterPage.CONFIRM_PASSWORD_INPUT, password),
                ClickOn.element(RegisterPage.REGISTER_BUTTON)
        );
    }
}
