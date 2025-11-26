package com.courier_sync.user_interfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class DashboardPage extends PageObject {

    public static final Target DASHBOARD_MAIN = Target.the("Dashboard Title")
            .locatedBy("//*[@id=\"root\"]/div[2]/main");
}
