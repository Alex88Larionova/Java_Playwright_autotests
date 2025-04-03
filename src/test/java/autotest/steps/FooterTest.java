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

public class FooterTest {
    private final PageObject pageObject;
    private final PlaywrightConfig playwrightConfig;

    @Autowired
    public FooterTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        this.pageObject = pageObject;
        this.playwrightConfig = playwrightConfig;
    }

    @Given("I open the Playwright footer page")
    public void iOpenThePlaywrightTestPage() {
        pageObject
                .getPage()
                .navigate(playwrightConfig
                        .getTestPageUrl());
    }

    @When("I check for the footer")
    public void iCheckTheFooter() {
        boolean footerExists = pageObject
        .getPage().locator(Locators.FOOTER_SELECTOR)
        .count() > 0;

        assertTrue(footerExists, "Футер должен присутствовать на странице");
        
        boolean hasContactLink = pageObject
        .getPage()
        .locator(Locators.CONTACT_LINK_SELECTOR)
        .count() > 0;
        
        assertTrue(hasContactLink, "Футер должен содержать ссылку на контактную информацию");
        
        boolean hasPrivacyPolicyLink = pageObject
        .getPage()
        .locator(Locators.CONTACT_LINK_SELECTOR)
        .count() > 0;
        
        assertTrue(hasPrivacyPolicyLink, "Футер должен содержать ссылку на политику конфиденциальности");
    }
    
    @Then("I verify the footer is displayed")
    public void isVerifyTheFooterIsDisplayed() {
        boolean footerVisible = pageObject
        .getPage()
        .locator(Locators.FOOTER_SELECTOR)
        .isVisible();

        assertTrue(footerVisible, "Футер должен быть виден");
    }
}



///Scenario: Check footer
//Given I open the Playwright footer page
//When I check for the footer
//Then I verify the footer is displayed
/// 
/// 
// Мы создали конструктор, который принимает два параметра PageObject и
// PlaywrightConfig. Эти параметры являются зависимостями, которые необходимы
// для выполнения тестов.
