package com.buggy_cars_rating.stepdefinitions;

import io.cucumber.java.Before;
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
import com.buggy_cars_rating.questions.Validatee;
import com.buggy_cars_rating.tasks.FindThe;
import com.buggy_cars_rating.tasks.OpenThe;
import com.buggy_cars_rating.user_interfaces.GooglePage;

public class FindUdeAStepDefinitions {

    public final Actor user = Actor.named("Usuario");

    @Managed(driver = "chrome", uniqueSession = true)
    public WebDriver theDriver;

    @Before
    public void config(){
        user.can(BrowseTheWeb.with(theDriver));
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario");
    }

    @Given("I am on the Google homepage")
    public void iAmOnTheGoogleHomepage() {
        user.attemptsTo(OpenThe.navigator(new GooglePage()));
    }
    @When("I search for U de A")
    public void iSearchFor() {
        user.attemptsTo(FindThe.keyword());
    }
    @Then("I should see tge UdeA's official website")
    public void iShouldSeeTgeUdeASOfficialWebsite() {
        user.should(
                GivenWhenThen.seeThat(
                        Validatee.thePageUrl("https://www.udea.edu.co/wps/portal/udea/web/inicio")
                )
        );
    }
}
