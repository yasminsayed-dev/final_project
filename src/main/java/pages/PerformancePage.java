package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PerformancePage {
    WebDriver performanceDriver;

    // Locators
    By performanceReviewTab = By.xpath("//span[text()='Performance']");
    By addButton = By.xpath("//button[normalize-space()='Add']");
    By employeeNameField = By.cssSelector("input[placeholder='Employee Name']");
    By supervisorField = By.cssSelector("input[placeholder='Supervisor Name']");
    By reviewScoreField = By.cssSelector("input[placeholder='Score']");
    By reviewCommentsField = By.cssSelector("textarea[placeholder='Comments']");
    By saveButton = By.xpath("//button[normalize-space()='Save']");
    By reviewTable = By.cssSelector("table.oxd-table");
    By reviewTableRow = By.xpath("//table[@class='oxd-table']//tr");
    By reviewScore = By.xpath("//td[contains(text(),'Score')]");
    By configureDropdown =By.xpath("//a[@id='menu_performance_listKpi']");

    // Constructor
    public PerformancePage(WebDriver driver) {
        performanceDriver = driver;
    }

    // Actions

    public void goToPerformanceReviewPage() {
        performanceDriver.findElement(performanceReviewTab).click();
    }

    public void clickAddButton() {
        performanceDriver.findElement(addButton).click();
    }

    public void fillReviewForm(String employeeName, String supervisorName, String score, String comments) {
        performanceDriver.findElement(employeeNameField).sendKeys(employeeName);
        performanceDriver.findElement(supervisorField).sendKeys(supervisorName);
        performanceDriver.findElement(reviewScoreField).sendKeys(score);
        performanceDriver.findElement(reviewCommentsField).sendKeys(comments);
    }

    public void clickSaveButton() {
        performanceDriver.findElement(saveButton).click();
    }

    public boolean isReviewListed() {
        WebDriverWait wait = new WebDriverWait(performanceDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(reviewTable));

        // Check if the review is present in the table
        return performanceDriver.findElements(reviewTableRow).size() > 0;
    }

    public boolean isReviewScoreVisible() {
        // Verifying that the score is visible in the review table
        return performanceDriver.findElement(reviewScore).isDisplayed();
    }

    public void waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(performanceDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement getReviewTable() {
        return performanceDriver.findElement(reviewTable);
    }
}
