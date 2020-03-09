package com.ss.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;

public class CategoryPage extends SomePage{
    private static final String CATEGORIES_LOCATOR="[class=\"a_category\"]";

    public ElementsCollection getCategoryElements(){
        return $$(CATEGORIES_LOCATOR);
    }

    public ItemPage clickOnFirstCategory(){
        getCategoryElements().first().click();
        return new ItemPage();
    }
}
