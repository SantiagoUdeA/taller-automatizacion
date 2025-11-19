package com.buggy_cars_rating.stepdefinitions;

import com.buggy_cars_rating.dto.UserDto;
import com.buggy_cars_rating.questions.Element;
import com.buggy_cars_rating.questions.IsVisible;
import com.buggy_cars_rating.tasks.NavigateTo;
import com.buggy_cars_rating.tasks.OpenThe;
import com.buggy_cars_rating.user_interfaces.CarModelPage;
import com.buggy_cars_rating.user_interfaces.HomePage;
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

public class HU3StepDefinitions {

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

    @Given("that I am on the home page")
    public void thatIAmOnTheHomePage() {
        user.attemptsTo(OpenThe.navigator(new HomePage()));
        WaitTime.waitFiveSeconds();
    }

    @When("I select the most popular car")
    public void iSelectTheMostPopularCar() {
        user.attemptsTo(NavigateTo.theMostPopularCar());
        WaitTime.waitFiveSeconds();
    }

    @Then("the system shows me the car specifications")
    public void theSystemShowsMeTheCarSpecifications() {
        user.should(seeThat(IsVisible.element(CarModelPage.SPECIFICATIONS_CARD)));
    }

    @And("the number of votes")
    public void theNumberOfRatings() {
        user.should(seeThat(IsVisible.element(CarModelPage.NUMBER_OF_VOTES)));
        WaitTime.waitFiveSeconds();
    }
}

