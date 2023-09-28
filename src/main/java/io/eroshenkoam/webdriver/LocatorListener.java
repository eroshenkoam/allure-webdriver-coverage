package io.eroshenkoam.webdriver;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocatorListener implements WebDriverListener {

    private final List<Locator> locators;

    public LocatorListener() {
        this.locators = new ArrayList<>();
    }

    public void afterAnyWebElementCall(final WebElement element,
                                       final Method method,
                                       final Object[] args,
                                       final Object result) {
        logAction(element);
    }

    public void attachLocators() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final String content = mapper.writeValueAsString(locators);
        Allure.attachment("allure-inspector-log.json", content);
    }

    private void logAction(final WebElement element) {
        getLocator(element).ifPresent(locator -> {
            Optional.of(element)
                    .filter(WrapsDriver.class::isInstance)
                    .map(WrapsDriver.class::cast)
                    .map(WrapsDriver::getWrappedDriver)
                    .map(WebDriver::getCurrentUrl)
                    .ifPresent(url -> locator.getUrls().add(url));
            locators.add(locator);
        });
    }

    private Optional<Locator> getLocator(final WebElement element) {
        System.out.println(element.toString());
        String[] pathVariables = (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");
        String type = pathVariables[0].trim();
        String value = pathVariables[1].trim();
        switch (type) {
            case "xpath":
            case "css selector":
                return Optional.of(new Locator().setType(type).setFullPath(value));
            default:
                return Optional.empty();
        }
    }
}
