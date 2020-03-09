package com.ss.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends SomePage {
    private static final String MAIN_PAGE_URL = "https://www.ss.com/en";

    public MainPage() {
        open(MAIN_PAGE_URL);
    }

    public SomePage clickOnTitle(String title) {
        $("[title=\"" + title + "\"]").click();
        if ($("[class=\"am\"]").exists()) {
            return new ItemsPage();
        } else return new CategoryPage();
    }
}
