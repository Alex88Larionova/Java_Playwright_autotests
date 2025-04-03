package autotest.config;

import org.springframework.context.annotation.Bean;

import autotest.Application;
import autotest.pages.PageObject;
import autotest.steps.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration // указывает на то, что этот класс является конфигурацией для Cucumber
@SpringBootTest(classes = Application.class) // Загружает контекст SpringBoot
public class CucumberSpringConfiguration {

    @Bean // Создает бины для каждого класса шагов, чтобы Spring мог управлять их
          // жизненным циклом
    public TitleAndCartTest stepDefinitions(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        return new TitleAndCartTest(pageObject, playwrightConfig);
    }

    @Bean
    public CatalogItemsTest catalogItemsTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        return new CatalogItemsTest(pageObject, playwrightConfig);
    }

    @Bean
    public FooterTest footerTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        return new FooterTest(pageObject, playwrightConfig);
    }

    @Bean
    public LogoTest logoTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        return new LogoTest(pageObject, playwrightConfig);
    }

    @Bean
    public NavigationMenuTest navigationMenuTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        return new NavigationMenuTest(pageObject, playwrightConfig);
    }

    @Bean
    public H1Test stepTwoDefinitions(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        return new H1Test(pageObject, playwrightConfig);
    }

    @Bean
    public ViewAllButtonTest viewAllButtonTest(PageObject pageObject, PlaywrightConfig playwrightConfig) {
        return new ViewAllButtonTest(pageObject, playwrightConfig);
    }
}
