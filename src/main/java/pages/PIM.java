package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    By configDropdown  = By.cssSelector("div.oxd-button-group > button.oxd-button--ghost");
    By optionalFields =By.xpath("//div[@role='menu']//a[normalize-space()='Optional Fields']");
    By userDropdown = By.cssSelector("p.oxd-userdropdown-name");
    By logoutMenuItem = By.cssSelector("a[href*='logout']");
    By paginationFooter = By.cssSelector("div.oxd-Pagination");
    By secondPageButton = By.xpath("//div[contains(@class,'oxd-Pagination')]//button[normalize-space()='2']");
    By employeeInfoHeader = By.cssSelector("h5.oxd-text--h5.oxd-table-header-title");
    By addEmployeeHeader = By.xpath("//h5[text()='Add Employee']");
    By addFirstNameField = By.name("firstName");
    By addLastNameField = By.name("lastName");
    By addEmployeeIdField = By.name("employeeId");



    // Optional locators
    /*By jobTitleDropdown         = By.xpath("//label[text()='Job Title']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
    By employmentStatusDropdown = By.xpath("//label[text()='Employment Status']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
    By subUnitDropdown          = By.xpath("//label[text()='Sub Unit']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
    By includeDropdown          = By.xpath("//label[text()='Include']/../following-sibling::div//div[contains(@class,'oxd-select-text-input')]");
    By supervisorField          = By.xpath("//label[text()='Supervisor Name']/../following-sibling::div//input");
    */
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
    public void clickSecondPageButton() {
        PIMDriver.findElement(secondPageButton).click();
    }

    public LoginPage logOut(){
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
    public WebElement getFooter(){
        waitForElementToBeVisible(paginationFooter);
        return PIMDriver.findElement(paginationFooter);
    }
    public WebElement getAddEmployeeHeader(){
        waitForElementToBeVisible(addEmployeeHeader);
        return PIMDriver.findElement(addEmployeeHeader);
    }
    public void addEmployeeFields(String firstName, String lastName, String employeeId){
        waitForElementToBeVisible(addFirstNameField);
        PIMDriver.findElement(addFirstNameField).sendKeys(firstName);
        waitForElementToBeVisible(addLastNameField);
        PIMDriver.findElement(addLastNameField).sendKeys(lastName);
        waitForElementToBeVisible(addEmployeeIdField);
        PIMDriver.findElement(addEmployeeIdField).sendKeys(employeeId);
    }

}
