package autotest.steps;

import autotest.config.PlaywrightConfig;
import autotest.pages.PageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import autotest.locators.Locators;

public class LogoTest {
    private final PageObject pageObject;
    private final PlaywrightConfig playwrightConfig;

    @Autowired
    public LogoTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        this.pageObject = pageObject;
        this.playwrightConfig = playwrightConfig;
    }

    @Given ("I open the Playwright logo page")
    public void iOpenThePlaywrightLogoPage() {
        pageObject
        .getPage()
        .navigate(playwrightConfig
                .getTestPageUrl());
    }

    @When ("I check for the logo")
    public void iCheckForTheLogo() {
        boolean logoExists = pageObject
        .getPage()
        .locator(Locators.LOGO_SELECTOR)
        .count() > 0;

        assertTrue (logoExists, "Логотип должен присутствовать на странице");
    }

    @Then ("I verify the logo is displayed")
    public void iVerifyTheLogoIsDisplayed() {
        boolean logoIsVisible = pageObject
        .getPage()
        .locator(Locators.LOGO_SELECTOR)
        .isVisible();

        assertTrue(logoIsVisible, "Логотип должен быть виден");

    }

}

// Мы создали конструктор, который принимает два параметра PageObject и
// PlaywrightConfig. Эти параметры являются зависимостями, которые необходимы
// для выполнения тестов.
