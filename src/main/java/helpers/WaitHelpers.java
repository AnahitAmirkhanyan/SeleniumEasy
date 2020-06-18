package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public interface WaitHelpers {
    int TIMEOUT = 30;

    default void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    default void waitForVisibilityOfElement(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    default void waitUntilPageLoads(WebDriver driver, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState ==='complete'"));
    }

    default  void refreshPageUntilAttributeToBeChanged(WebDriver driver, WebElement element, String attribute) {
        String attributeValue = element.getAttribute(attribute);
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10).pollingEvery(Duration.ofSeconds(2));
        wait.until(webDriver -> {
            if (attributeValue.equals(element.getAttribute(attribute))) {
                driver.navigate().refresh();
                return false;
            } else {
                return true;
            }
        });
    }
}
