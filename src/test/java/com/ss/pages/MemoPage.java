package com.ss.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MemoPage extends SomePage {
    private static final String ITEMS_LOCATOR = "[class=\"am\"]";
    private static final String CLEAR_FAVOURITES_BUTTON_TEXT = "Clear selected";
    private static final String REMOVE_FAVOURITES_BUTTON_TEXT = "Remove selected from favourites";
    private static final String CHECKBOXES_LOCATOR ="[type=\"checkbox\"]";

    public String getFirstItemName() {
        return getItems().first().getText();
    }

    public ElementsCollection getItems() {
        return $$(ITEMS_LOCATOR);
    }

    public ElementsCollection getCheckboxes(){
        return $$(CHECKBOXES_LOCATOR);
    }

    public void clickClearFavourites(){
        $(new Selectors.ByText(CLEAR_FAVOURITES_BUTTON_TEXT)).click();
    }

    public void clickRemoveFavourites(){
        $(new Selectors.ByText(REMOVE_FAVOURITES_BUTTON_TEXT)).click();
    }
}
