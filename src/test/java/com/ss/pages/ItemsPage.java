package com.ss.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ItemsPage extends SomePage {

    private static final String ITEMS_LOCATOR = "[class=\"am\"]";
    private static final String CHECKBOXES_LOCATOR = "[type=\"checkbox\"]";
    private static final String ADD_TO_FAVOURITE_TEXT = "Pievienot izvēlētos Memo";
    private static final String ALERT_BUTTON_LOCATOR = "#alert_ok";

    public ItemPage clickOnFirstItem() {
        getItems().first().click();
        return new ItemPage();
    }

    public String getFirstItemName() {
        return getItems().first().getText();
    }

    public ElementsCollection getItems() {
        return $$(ITEMS_LOCATOR);
    }

    public ElementsCollection getCheckboxes() {
        return $$(CHECKBOXES_LOCATOR);
    }

    public String getFirstItemLink() {
        return getItems().first().getAttribute("href");
    }

    public void clickOkAlert(){
        $(ALERT_BUTTON_LOCATOR).click();
    }

    public void clickAddToFavourite(){
        $(new Selectors.ByText(ADD_TO_FAVOURITE_TEXT)).click();
    }
}
