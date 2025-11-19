package com.buggy_cars_rating.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/hu3_most_popular_car_model.feature",
        glue = "com/buggy_cars_rating/stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "json:target/cucumber/hu3_most_popular_car.json"
        }
)
public class HU3Runner {}

