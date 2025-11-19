package com.buggy_cars_rating.user_interfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("/register")
public class RegisterPage extends PageObject {

    public static final Target USERNAME_INPUT = Target.the("Username input field")
            .locatedBy("//*[@id=\"username\"]");

    public static final Target FIRST_NAME_INPUT = Target.the("First Name input field")
            .locatedBy("//*[@id=\"firstName\"]");

    public static final Target LAST_NAME_INPUT = Target.the("Last Name input field")
            .locatedBy("//*[@id=\"lastName\"]");

    public static final Target PASSWORD_INPUT = Target.the("Password input field")
            .locatedBy("//*[@id=\"password\"]");

    public static final Target CONFIRM_PASSWORD_INPUT = Target.the("Confirm Password input field")
            .locatedBy("//*[@id=\"confirmPassword\"]");

    public static final Target REGISTER_BUTTON = Target.the("Register button")
            .locatedBy("/html/body/my-app/div/main/my-register/div/div/form/button");

    public static final Target ALERT_MESSAGE = Target.the("Alert message after registration")
            .locatedBy("/html/body/my-app/div/main/my-register/div/div/form/div[6]");
}
