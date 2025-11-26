package com.courier_sync.tasks;

import com.courier_sync.models.User;
import com.courier_sync.user_interfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/*
* Tarea para llenar el formulario de inicio de sesión y enviarlo.
*/
public class SignIn implements Task {

    private final String email;
    private final String password;

    public SignIn(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static SignIn with(User user) {
        return instrumented(SignIn.class, user.getEmail(), user.getPassword());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateTo.page(new LoginPage()),
                Enter.theValue(email).into(LoginPage.EMAIL_INPUT),
                Enter.theValue(password).into(LoginPage.PASSWORD_INPUT),
                Click.on(LoginPage.SUBMIT_BUTTON)
        );
    }

}
