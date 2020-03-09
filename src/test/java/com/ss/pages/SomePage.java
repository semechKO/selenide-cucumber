package com.ss.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public abstract class SomePage {
    private final static String MEMO_LOCATOR = "[title=\"Memo\"]";

    public MemoPage clickOnMemo() {
        $(MEMO_LOCATOR).click();
        return new MemoPage();
    }
}
