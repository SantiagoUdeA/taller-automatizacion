package com.courier_sync.tasks;

import com.courier_sync.interactions.ClickOn;
import com.courier_sync.interactions.EnterTheValue;
import com.courier_sync.models.User;
import com.courier_sync.user_interfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

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
                EnterTheValue.into(LoginPage.EMAIL_INPUT, email),
                EnterTheValue.into(LoginPage.PASSWORD_INPUT, password),
                Click.on(LoginPage.SUBMIT_BUTTON)
        );
    }

}
