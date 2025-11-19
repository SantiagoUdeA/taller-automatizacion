package com.buggy_cars_rating.stepdefinitions;

import com.buggy_cars_rating.dto.UserDto;
import com.buggy_cars_rating.questions.Element;
import com.buggy_cars_rating.questions.TableColumnContainsText;
import com.buggy_cars_rating.tasks.FillLoginForm;
import com.buggy_cars_rating.tasks.FillRegistrationForm;
import com.buggy_cars_rating.tasks.OpenThe;
import com.buggy_cars_rating.tasks.VoteCarModel;
import com.buggy_cars_rating.user_interfaces.CarModelPage;
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
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

public class UserVotesStepDefinitions {

    private final UserDto userDto = RandomUserFactory.generateRandomUser();
    public final Actor user = Actor.named(userDto.firstName());
    public String comment;

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config(){
        user.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(userDto.firstName());
    }


    @Given("that I am authenticated in the application")
    public void iAmAuthenticatedInTheApplication() {
        user.attemptsTo(OpenThe.navigator(new RegisterPage()));
        user.attemptsTo(
                FillRegistrationForm.withData(
                        userDto.username(),
                        userDto.firstName(),
                        userDto.lastName(),
                        userDto.password()
                )
        );
        WaitTime.waitForSeconds(5);
        user.attemptsTo(
                FillLoginForm.withData(
                        userDto.username(),
                        userDto.password()
                )
        );
        WaitTime.waitFiveSeconds();
    }

    @And("I am on the page of a car model")
    public void thatIAmOnThePageOfACarModel() {
        user.attemptsTo(OpenThe.navigator(new CarModelPage()));
        WaitTime.waitFiveSeconds();
    }

    @When("I submit a vote with the comment {string}")
    public void iVoteForTheCarModelWithTheComment(String comment) {
        user.attemptsTo(VoteCarModel.withComment(comment));
        WaitTime.waitFiveSeconds();
    }

    @Then("the system shows me a confirmation message {string}")
    public void theSystemShowsMeTheMessage(String message) {
        user.should(GivenWhenThen.seeThat(Element.withTarget(CarModelPage.SUCCESS_MESSAGE).says(message)));
        WaitTime.waitFiveSeconds();
    }

    @Given("that I have submitted a vote with the comment {string}")
    public void thatIHaveSubmittedAVoteWithTheComment(String comment) {
        this.comment = comment;
        WaitTime.waitFiveSeconds();
    }

    @Then("I can see my comment {string}")
    public void iCanSeeMyComment(String comment) {
        user.should(
                GivenWhenThen.seeThat(TableColumnContainsText.in(CarModelPage.COMMENTS_COLUMN, comment))
        );
        WaitTime.waitFiveSeconds();
    }
}

