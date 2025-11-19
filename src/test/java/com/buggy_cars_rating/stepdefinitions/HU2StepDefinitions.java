package com.buggy_cars_rating.stepdefinitions;

import com.buggy_cars_rating.dto.UserDto;
import com.buggy_cars_rating.interactions.ClickOn;
import com.buggy_cars_rating.questions.Element;
import com.buggy_cars_rating.tasks.FillLoginForm;
import com.buggy_cars_rating.tasks.FillRegistrationForm;
import com.buggy_cars_rating.tasks.OpenThe;
import com.buggy_cars_rating.user_interfaces.HomePage;
import com.buggy_cars_rating.user_interfaces.RegisterPage;
import com.buggy_cars_rating.utils.RandomUserFactory;
import com.buggy_cars_rating.utils.WaitTime;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class HU2StepDefinitions {

    private final UserDto userDto = RandomUserFactory.generateRandomUser();
    public final Actor user = Actor.named(userDto.firstName());

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config(){
        user.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(userDto.firstName());
    }

    @Given("That I'm logged out")
    public void thatIMLoggedOut() {
        if (HomePage.LOGOUT_BUTTON != null){
            user.attemptsTo(ClickOn.element(HomePage.LOGOUT_BUTTON));
            WaitTime.waitFiveSeconds();
        }

    }

    @And("I have a registered account with name {string}")
    public void iHaveARegisteredAccount(String name) {
        user.attemptsTo(OpenThe.navigator(new RegisterPage()));
        user.attemptsTo(
                FillRegistrationForm.withData(
                        userDto.username(),
                        name,
                        userDto.lastName(),
                        userDto.password()
                )
        );
        WaitTime.waitForSeconds(2);

    }

    @And("I am on the login page")
    public void thatIAmOnTheLoginPage() {
        user.attemptsTo(OpenThe.navigator(new HomePage()));
        WaitTime.waitFiveSeconds();
    }

    @When("I enter my login data")
    public void iEnterMyLoginData() {
        user.attemptsTo(
                FillLoginForm.withData(
                        userDto.username(),
                        userDto.password()
                )
        );
        WaitTime.waitFiveSeconds();
    }

    @Then("the system shows me a welcome message {string}")
    public void theSystemShowsMeAWelcomeMessage(String message) {
        user.should(seeThat(Element.withTarget(HomePage.WELCOME_MESSAGE).says(message)));
        WaitTime.waitFiveSeconds();
    }

    @When("I enter an invalid username or password")
    public void iEnterAnInvalidUsernameOrPassword() {
        user.attemptsTo(
                FillLoginForm.withData(
                        "invalidUser",
                        "invalidPass"
                )
        );
        WaitTime.waitFiveSeconds();
    }

    @Then("the system shows me an error message {string}")
    public void theSystemShowsMeAnErrorMessage(String message) {
        user.should(seeThat(Element.withTarget(HomePage.INVALID_LOGIN_MESSAGE).says(message)));
    }
}
