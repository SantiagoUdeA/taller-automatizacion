package com.buggy_cars_rating.user_interfaces;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

@DefaultUrl("https://buggy.justtestit.org/model/ckl2phsabijs71623vk0%7Cckl2phsabijs71623vog")
public class CarModelPage extends PageObject {

    public static final Target SPECIFICATIONS_CARD = Target.the("Specifications card")
            .locatedBy("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[1]/div");

    public static final Target NUMBER_OF_VOTES = Target.the("Reviews card")
            .locatedBy("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[1]/h4/strong");

    public static final Target COMMENT_TEXTAREA = Target.the("Comment textarea")
            .locatedBy("//*[@id=\"comment\"]");

    public static final Target VOTE_BUTTON = Target.the("Vote button")
            .locatedBy("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/div/button");

    public static final Target SUCCESS_MESSAGE = Target.the("Success message after voting")
            .locatedBy("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[2]/p");

    public static final Target COMMENTS_COLUMN =
            Target.the("comments column")
                    .locatedBy("//table[contains(@class,'table')]/tbody/tr/td[3]");

}
