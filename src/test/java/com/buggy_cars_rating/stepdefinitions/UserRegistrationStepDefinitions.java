package com.buggy_cars_rating.stepdefinitions;

import com.buggy_cars_rating.dto.UserDto;
import com.buggy_cars_rating.questions.Element;
import com.buggy_cars_rating.tasks.FillRegistrationForm;
import com.buggy_cars_rating.tasks.OpenThe;
import com.buggy_cars_rating.user_interfaces.RegisterPage;
import com.buggy_cars_rating.utils.RandomUserFactory;
import com.buggy_cars_rating.utils.WaitTime;
import io.cucumber.java.Before;
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

public class UserRegistrationStepDefinitions {

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

    @Given("that I am on the registration page")
    public void thatIAmOnTheRegistrationPage() {
        user.attemptsTo(OpenThe.navigator(new RegisterPage()));
        WaitTime.waitFiveSeconds();
    }

    @When("I enter my registration data")
    public void iEnterMyRegistrationData() {
        user.attemptsTo(
            FillRegistrationForm.withData(
                    userDto.username(),
                    userDto.firstName(),
                    userDto.lastName(),
                    userDto.password()
            )
        );
        WaitTime.waitFiveSeconds();
    }

    @Then("the system shows me the message {string}")
    public void theSystemShowsMeTheMessage(String message) {
        user.should(seeThat(Element.withTarget(RegisterPage.ALERT_MESSAGE).says(message)));
        WaitTime.waitFiveSeconds();
    }

    @When("I enter a password {string}")
    public void iEnterAPasswordPassword(String password) {
        user.attemptsTo(
                FillRegistrationForm.withData(
                        userDto.username(),
                        userDto.firstName(),
                        userDto.lastName(),
                        password
                )
        );
        WaitTime.waitFiveSeconds();
    }
}
