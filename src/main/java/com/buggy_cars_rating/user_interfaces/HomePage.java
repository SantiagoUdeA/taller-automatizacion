package com.buggy_cars_rating.user_interfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://buggy.justtestit.org/")
public class HomePage extends PageObject {

    public static final Target USERNAME_INPUT = Target.the("Username input field")
            .locatedBy("/html/body/my-app/header/nav/div/my-login/div/form/div/input[1]");

    public static final Target PASSWORD_INPUT = Target.the("Password input field")
            .locatedBy("/html/body/my-app/header/nav/div/my-login/div/form/div/input[2]");

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .locatedBy("/html/body/my-app/header/nav/div/my-login/div/form/button");

    public static final Target WELCOME_MESSAGE = Target.the("Welcome message after login")
            .locatedBy("/html/body/my-app/header/nav/div/my-login/div/ul/li[1]/span");

    public static final Target INVALID_LOGIN_MESSAGE = Target.the("Invalid login message")
            .locatedBy("/html/body/my-app/header/nav/div/my-login/div/form/div/span");

    public static final Target LOGOUT_BUTTON = Target.the("Logout button")
            .locatedBy("/html/body/my-app/header/nav/div/my-login/div/ul/li[3]/a");
}
