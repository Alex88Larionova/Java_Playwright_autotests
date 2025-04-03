package autotest.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import com.microsoft.playwright.Playwright;

import autotest.config.PlaywrightConfig;
import autotest.pages.PageObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class H1Test {
    private final PageObject pageObject;
    private final PlaywrightConfig playwrightConfig;

    @Autowired
    public H1Test(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        this.pageObject = pageObject;
        this.playwrightConfig = playwrightConfig;
    }

    @Given("I open the Playwright H1 header page")
    public void iOpenThePlaywrightH1HeaderPage() {
        pageObject
                .getPage()
                .navigate(playwrightConfig
                        .getTestPageUrl());
    }

    @When("I check for the H1 header")
    public void iCheckForTheH1Header() {
        String headerText = pageObject
        .getHeaderText();

        assertTrue(headerText.contains("Каталог"));
    }

    @Then("I close the browser after checking tests")
    public void iCloseTheBrowseAfterCheckingTests() {
        pageObject
        .getPage()
        .context()
        .browser()
        .close();
    }

}

// Мы создали конструктор, который принимает два параметра PageObject и
// PlaywrightConfig. Эти параметры являются зависимостями, которые необходимы
// для выполнения тестов.
