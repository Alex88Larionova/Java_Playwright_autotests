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


public class CatalogItemsTest {
    private final PageObject pageObject;
    private final PlaywrightConfig playwrightConfig;

    @Autowired
    public CatalogItemsTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        this.pageObject = pageObject;
        this.playwrightConfig = playwrightConfig;
    }

    @Given("I open the Playwright catalog items page")
    public void iOpenThePlaywrightCatalogPage() {
        pageObject
                .getPage()
                .navigate(playwrightConfig
                        .getTestPageUrl());
    }

    @When("I check the catalog items")
    public void iCheckTheCatalogItems() {
        pageObject.getPage().waitForSelector(Locators.CATALOG_ITEMS_LIST);
        boolean catalogExists = pageObject
        .getPage().locator(Locators.CATALOG_ITEMS_LIST)
        .count() > 0;

        assertTrue(catalogExists, "Должен быть хотя бы 1 товар в каталоге");
    }

    @Then("I verify catalog items are displayed")
    public void iVerifyCatalogItemsAreDisplayed() {
        pageObject
        .getPage()
        .waitForSelector(Locators.CATALOG_ITEMS_LIST);
        int itemCount = pageObject
        .getPage()
        .locator(Locators.CATALOG_ITEMS_LIST)
        .count();

        assertTrue(itemCount > 2, "Должно быть больше 2 товаров в каталоге, найдено: " + itemCount);
    }
}

// Мы создали конструктор, который принимает два параметра PageObject и
// PlaywrightConfig. Эти параметры являются зависимостями, которые необходимы
// для выполнения тестов.
// Внедрение зависимостей: Когда Spring создает экземпляр TitleAndCartTest, он
// автоматически находит бины PageObject и PlaywrightConfig в контексте
// приложения и передает их в конструктор. Это происходит благодаря аннотации
// @Autowired.

// Использование зависимостей: После того как зависимости внедрены, вы можете
// использовать pageObject и playwrightConfig в методах тестирования, не
// беспокоясь о том, как они были созданы.
