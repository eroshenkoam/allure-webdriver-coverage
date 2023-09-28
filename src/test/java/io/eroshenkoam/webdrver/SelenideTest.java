package io.eroshenkoam.webdrver;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.eroshenkoam.webdriver.LocatorListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideTest {

    private LocatorListener locatorListener;
    private WebDriver driver;

    @BeforeEach
    public void initDriver() {
        locatorListener = new LocatorListener();
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(new EventFiringDecorator<>(locatorListener).decorate(driver));
    }

    @Test
    public void testCodeTab() throws IOException {
        step("Открываем главную страницу", () -> {
            open("https://github.com/eroshenkoam/allure-example");
        });
        step("Проверяем наличие таба Code", () -> {
            $x("//a[@id='code-tab']").should(Condition.exist);
        });
        locatorListener.attachLocators();
    }

    @Test
    public void testIssuesTab() throws IOException {
        step("Открываем главную страницу", () -> {
            open("https://github.com/eroshenkoam/allure-example");
        });
        step("Проверяем наличие таба Issues", () -> {
            $x("//a[@id='issues-tab']").should(Condition.exist);
        });
        locatorListener.attachLocators();
    }

    @Test
    public void testPullRequestsTab() throws IOException {
        step("Открываем главную страницу", () -> {
            open("https://github.com/eroshenkoam/allure-example");
        });
        step("Проверяем наличие таба Pull Requests", () -> {
            $x("//a[@id='pull-requests-tab']").should(Condition.exist);
        });
        locatorListener.attachLocators();
    }

    @Test
    public void testActionsTab() throws IOException {
        step("Открываем главную страницу", () -> {
            open("https://github.com/eroshenkoam/allure-example");
        });
        step("Проверяем наличие таба Actions", () -> {
            $x("//a[@id='actions-tab']").should(Condition.exist);
        });
        locatorListener.attachLocators();
    }

    @Test
    public void testProjectsTab() throws IOException {
        step("Открываем главную страницу", () -> {
            open("https://github.com/eroshenkoam/allure-example");
        });
        step("Проверяем наличие таба Projects", () -> {
            $x("//a[@id='projects-tab']").should(Condition.exist);
        });
        locatorListener.attachLocators();
    }

    @Test
    public void testSecurityTab() throws IOException {
        step("Открываем главную страницу", () -> {
            open("https://github.com/eroshenkoam/allure-example");
        });
        step("Проверяем наличие таба Security", () -> {
            $x("//a[@id='security-tab']").should(Condition.exist);
        });
        locatorListener.attachLocators();
    }

    @Test
    public void testInsightsTab() throws IOException {
        step("Открываем главную страницу", () -> {
            open("https://github.com/eroshenkoam/allure-example");
        });
        step("Проверяем наличие таба Insights", () -> {
            $x("//a[@id='insights-tab']").should(Condition.exist);
        });
        locatorListener.attachLocators();
    }

    @AfterEach
    public void destroyDriver() {
        driver.quit();
    }

}
