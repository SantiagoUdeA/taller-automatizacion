package com.buggy_cars_rating.user_interfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CarModelPage extends PageObject {


    public static final Target SPECIFICATIONS_CARD = Target.the("Specifications card")
            .locatedBy("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[1]/div");

    public static final Target NUMBER_OF_VOTES = Target.the("Reviews card")
            .locatedBy("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[1]/h4/strong");
}
