package com.ss.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.ss.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SiteSteps {

    private ScenarioContext scenarioContext;

    public SiteSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("click on {string} title")
    public void clickOnTheTitle(String title) throws InterruptedException {
        new MainPage().clickOnTitle(title);
    }

    @And("click on the first item")
    public void clickOnTheFirstItem() {
        new ItemsPage().clickOnFirstItem();
    }

    @And("add first item to favourites")
    public void addFirstItemToFavourites() {
        ItemPage itemPage = new ItemPage();
        itemPage.clickAddToFavourites();
        itemPage.clickOkOnAlertWindow();
    }

    @And("save first item link as {string}")
    public void addItemLink(String key) {
        String link = new ItemsPage().getFirstItemLink();
        scenarioContext.setContext(key, link);
    }

    @And("check that add to favourite is blue")
    public void checkThatAddToFavouritesIsBlue() {
        elementShouldHaveColor(new ItemPage().getAddToFavourites(), "rgba(0, 102, 204, 1)");
    }

    @And("check that add to favourites is grey")
    public void checkThatAddToFavouritesIsGrey() {
        elementShouldHaveColor(new ItemPage().getAddToFavourites(), "rgba(119, 119, 119, 1)");
    }


    public void elementShouldHaveColor(SelenideElement element, String color) {
        element.shouldHave(Condition.cssValue("color", color));
    }

    @And("check that memo count is {int}")
    public void checkThatMemoCountIs(int count) {
        int resCount = new ItemPage().getMemoCount();
        Assert.assertEquals(resCount, count);
    }

    @And("check that memo items count is {int}")
    public void checkThatMemoItemsCountEquals(int expected) {
        int actual = new MemoPage().getItems().size();
        Assert.assertEquals(actual, expected);

    }

    @And("go to memo")
    public void goToMemo() {
        new MainPage().clickOnMemo();
    }

    @And("check that first item link is in items")
    public void checkFirstItemNameInMemoEqualsGiven() {
        ElementsCollection items = new MemoPage().getItems();
        SelenideElement actual = items.findBy(Condition.attribute("href", scenarioContext.getContext("itemLink").toString()));
        Assert.assertNotNull(actual);
    }

    @And("click on the first category")
    public void clickOnTheFirstCategory() {
        new CategoryPage().clickOnFirstCategory();
    }

    @And("go to main page")
    public void goToMainPage() {
        new MainPage();
    }

    @And("remove favourite items")
    public void removeFavouriteItems() {
        MemoPage memoPage = new MemoPage();
        ElementsCollection checkboxes = memoPage.getCheckboxes();
        for (SelenideElement check : checkboxes) {
            check.click();
        }
        memoPage.clickRemoveFavourites();

    }

    @And("add items to favourites")
    public void addItemsToFavourite() {
        ItemsPage itemsPage = new ItemsPage();
        ElementsCollection checkboxes = itemsPage.getCheckboxes();
        for (SelenideElement check : checkboxes) {
            check.click();
        }
        itemsPage.clickAddToFavourite();
        itemsPage.clickOkAlert();
    }

    @And("save all items links to list")
    public void saveAllItemsLinks() {
        ItemsPage itemsPage = new ItemsPage();
        List linksList = new ArrayList();
        ElementsCollection items = itemsPage.getItems();
        for (SelenideElement item : items) {
            linksList.add(item.getAttribute("href"));
        }
        Collections.sort(linksList);
        scenarioContext.setContext("expectedLinksList", linksList);
    }

    @And("check that links list are equals")
    public void checkThatLinksAreEqual() {
        MemoPage memoPage = new MemoPage();
        ElementsCollection items = memoPage.getItems();
        List actualLinksList = new ArrayList();
        for (SelenideElement item : items) {
            actualLinksList.add(item.getAttribute("href"));
        }
        Collections.sort(actualLinksList);
        Assert.assertTrue(actualLinksList.equals(scenarioContext.getContext("expectedLinksList")));
    }

}
