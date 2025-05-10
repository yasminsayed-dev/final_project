package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PIM {
    WebDriver PIMDriver;
    //Locators
    By employeeNameField    = By.cssSelector("input[placeholder='Type for hints...']");
    By employeeIdField      = By.cssSelector("input[placeholder='Employee Id']");
    By resetButton     = By.cssSelector("button[type='reset']");
    By searchButton    = By.cssSelector("button[type='submit']");
    By addButton       = By.xpath("//button[normalize-space(.)='Add']");
    By configDropdown  = By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']");
    By optionalFields =By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul/li[1]/a");
    By userDropdown = By.cssSelector("p.oxd-userdropdown-name");
    By logoutMenuItem = By.cssSelector("a[href*='logout']");
    By paginationFooter = By.xpath("//footer[contains(@class,'oxd-layout-footer')]");
    By secondPageButton = By.xpath("//div[contains(@class,'oxd-Pagination')]//button[normalize-space()='2']");
    By employeeInfoHeader = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5");
    By addEmployeeHeader = By.xpath("//h6[text()='Add Employee']");
    By addFirstNameField = By.name("firstName");
    By addLastNameField = By.name("lastName");
    By submitButton= By.cssSelector("button[type='submit'].oxd-button--secondary");



    //constructor
    public PIM(WebDriver driver) {
        PIMDriver = driver;
    }
    //Actions


    public WebElement getEmployeeInfoHeader() {
        waitForElementToBeVisible(employeeInfoHeader);
        return PIMDriver.findElement(employeeInfoHeader);
    }
    public WebElement findElement(By locator) {
        waitForElementToBeVisible(locator);
        return PIMDriver.findElement(locator);
    }
    public void typeEmployeeName(String name) {
        waitForElementToBeVisible(employeeNameField);
        PIMDriver.findElement(employeeNameField).sendKeys(name);

    }
    public void typeEmployeeId(String id) {
        waitForElementToBeVisible(employeeIdField);
        PIMDriver.findElement(employeeIdField).sendKeys(id);
    }
    public void clickResetButton() {
        waitForElementToBeClickable(resetButton);
        PIMDriver.findElement(resetButton).click();
    }
    public void clickSearchButton() {
        waitForElementToBeClickable(searchButton);
        PIMDriver.findElement(searchButton).click();
    }
    public void clickAddButton() {
        waitForElementToBeClickable(addButton);
        PIMDriver.findElement(addButton).click();
    }
    public void clickConfigDropdown() {
        waitForElementToBeClickable(configDropdown);
        PIMDriver.findElement(configDropdown).click();
    }
    public void optionalFields() {
        waitForElementToBeClickable(optionalFields);
        PIMDriver.findElement(optionalFields).click();
    }
//    public void clickSecondPageButton() {
//        PIMDriver.findElement(secondPageButton).click();
//    }

    public LoginPage logout(){
        waitForElementToBeVisible(userDropdown);
        waitForElementToBeClickable(userDropdown);
        PIMDriver.findElement(userDropdown).click();
        waitForElementToBeVisible(logoutMenuItem);
        waitForElementToBeClickable(logoutMenuItem);
        PIMDriver.findElement(logoutMenuItem).click();
        return new LoginPage(PIMDriver);
    }

    public void waitForElementToBeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(PIMDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator){
        WebDriverWait wait = new WebDriverWait(PIMDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
//    public WebElement getFooter(){
//        waitForElementToBeVisible(paginationFooter);
//        return PIMDriver.findElement(paginationFooter);
//    }
    public WebElement getAddEmployeeHeader(){
        waitForElementToBeVisible(addEmployeeHeader);
        return PIMDriver.findElement(addEmployeeHeader);
    }
    public void addEmployeeFields(String firstName, String lastName){
        waitForElementToBeVisible(addFirstNameField);
        PIMDriver.findElement(addFirstNameField).sendKeys(firstName);
        waitForElementToBeVisible(addLastNameField);
        PIMDriver.findElement(addLastNameField).sendKeys(lastName);
    }
    public void clickSubmitButton(){
        waitForElementToBeClickable(submitButton);
        PIMDriver.findElement(submitButton).click();
    }

//    public void scrollToFooterWithEnd() {
//        new Actions(PIMDriver)
//                .sendKeys(Keys.END)
//                .build()
//                .perform();
//    }
//
//    /** Scrolls until the footer element is visible. */
//    public void scrollToFooterElement() {
//        WebElement footer = PIMDriver.findElement(paginationFooter);
//        new Actions(PIMDriver)
//                .scrollToElement(footer)
//                .perform();
//    }
}


