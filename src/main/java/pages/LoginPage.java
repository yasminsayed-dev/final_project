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


    public void typeUsername(String username) {

        loginDriver.findElement(userNameLocator).sendKeys(username);
    }

    public void typePassword(String password) {

        loginDriver.findElement(this.passwordLocator).sendKeys(password);
    }


    public void clickLogin() {
        loginDriver.findElement(buttonLocator).click();
    }

    public PIM clickPIMModule() {
        loginDriver.findElement(PIMModule).click();
        return new PIM(loginDriver);
    }

    }

