package com.ss.steps.hooks;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class Hooks{

    @Before
    public void initializeTest(){
        System.out.println("Opening main site");
        open("https://www.ss.com/en");
        System.out.println(WebDriverRunner.getWebDriver().manage().getCookies());
    }

    @Before(value = "@reweestartDriver")
    public void restartDriver(){
        closeWebDriver();
        System.out.println("Opening main site");
        open("https://www.ss.com/en");
        System.out.println(WebDriverRunner.getWebDriver().manage().getCookies());
    }



    @After
    public void tearDownTest(){
//        closeWebDriver();
    }
}
