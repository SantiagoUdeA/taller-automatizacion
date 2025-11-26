package com.courier_sync.stepdefinitions;

import com.courier_sync.models.User;
import com.courier_sync.questions.Dashboard;
import com.courier_sync.questions.ErrorMessageDisplayed;
import com.courier_sync.tasks.SignIn;
import com.courier_sync.utils.Wait;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.ClearCookiesPolicy;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinitions {

    private User model;
    public Actor user;

    @Managed(driver = "chrome", uniqueSession = true, clearCookies = ClearCookiesPolicy.BeforeEachTest)
    public WebDriver theDriver;

    @Before
    public void config() {
        user = Actor.named("Usuario");
        user.can(BrowseTheWeb.with(theDriver));
    }

    @After
    public void cleanUp() {
        // Limpiar cookies y cerrar el navegador después de cada escenario
        // para evitar sesiones previas
        theDriver.manage().deleteAllCookies();
        theDriver.quit();
    }


    @Given("the user has valid authentication details")
    public void theUserHasValidAuthenticationDetails() {
        model = User.valid();
    }

    @When("they attempt to sign in")
    public void theyAttemptToSignIn() {
        user.attemptsTo(SignIn.with(model));
        Wait.twoSeconds();
    }

    @Then("they should gain access to the Billing and Payments module")
    public void theyShouldGainAccessToTheBillingAndPaymentsModule() {
        user.should(seeThat(Dashboard.isDisplayed()));
        Wait.twoSeconds();
    }

    @Given("the user provides invalid authentication details")
    public void theUserProvidesInvalidAuthenticationDetails() {
        model = User.invalid();
    }

    @Then("they should be informed that the authentication details are incorrect")
    public void theyShouldBeInformedThatTheAuthenticationDetailsAreIncorrect() {
        Wait.forMilliseconds(100);
        user.should(seeThat(ErrorMessageDisplayed.text(), equalTo("Email o contraseña incorrectos")));
        Wait.twoSeconds();
    }
}
