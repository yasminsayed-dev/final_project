package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    //driver
    WebDriver loginDriver;

    //Locators
    By userNameLocator=By.name("username");
    By passwordLocator=By.name("password");
    By buttonLocator=By.cssSelector("button[type='submit']");
    By PIMModule=By.xpath("//span[text()='PIM']");
    By performaceModule=By.xpath("//span[text()='performance']");
    //constructor
    public LoginPage(WebDriver driver) {
        loginDriver = driver;
        }
    //Actions



   /* WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(10));

    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }*/

    private WebElement waitForElementToBeClickable(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitForElementToBeVisible(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void typeUsername(String username) {

        WebElement usernameField = waitForElementToBeVisible(userNameLocator, 10);
        usernameField.sendKeys(username);
    }

    public void typePassword(String password) {

        WebElement passwordField = waitForElementToBeVisible(passwordLocator, 10);
        passwordField.sendKeys(password);
    }


    public void clickLogin() {

        WebElement loginButton = waitForElementToBeClickable(buttonLocator, 10);
        loginButton.click();
    }

    public PIM clickPIMModule() {
        WebElement pimModule = waitForElementToBeClickable(PIMModule, 10);
        pimModule.click();
        return new PIM(loginDriver);
    }

    public PerformancePage clickPerformanceModule() {
        WebElement performModule = waitForElementToBeClickable(performaceModule, 10);
        performModule.click();
        return new PerformancePage(loginDriver);
    }
    }
