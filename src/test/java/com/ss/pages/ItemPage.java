package com.ss.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ItemPage extends SomePage{
    private static final String ADD_TO_FAVOURITES_LOCATOR = "#a_fav";
    private static final String ALERT_BUTTON_LOCATOR = "#alert_ok";
    private static final String MEMO_NUMBER_LOCATOR = "#mnu_fav_id";

    public void clickAddToFavourites() {
        $(ADD_TO_FAVOURITES_LOCATOR).click();
    }

    public void clickOkOnAlertWindow() {
        System.out.println("Alert is clicked");
        $(ALERT_BUTTON_LOCATOR).click();
    }

    public SelenideElement getAddToFavourites() {
        return $(ADD_TO_FAVOURITES_LOCATOR);
    }

    public Integer getMemoCount(){
        $(MEMO_NUMBER_LOCATOR).shouldBe(Condition.visible);
        System.out.println("Return memo count");
        return Integer.parseInt($(MEMO_NUMBER_LOCATOR).getText().replaceAll("\\D+",""));
    }
}
