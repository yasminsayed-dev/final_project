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
    By confgDropdown = By.xpath("//a[@id='menu_performance_Configure']//span[text()='Configure']");
    By KPI = By.xpath("//a[@id='menu_performance_addKpi']//span[text()='KPIs']");
    By Add = By.xpath("//input[@id='btnAdd' and @value='Add']");
    By KeyPerformanceIndicator =By.xpath("//input[@id='defineKpi_keyPerformanceIndicators']");
    By configureDropdown =By.xpath("//a[@id='menu_performance_listKpi']");
     By jobtitlefeild = By.xpath("//select[@id='defineKpi_jobTitleCode']");
     By jobtitle =By.xpath(
             "//select[@id='defineKpi_jobTitleCode']/option[normalize-space(.)='Automation Tester']"
     );
     By SaveButton = By.xpath("//input[@id='btnSave' and @value='Save']");
     By Mytrakers =By.xpath("//input[@id='btnAdd' and @value='Add']");
     By viewbutton  = By.xpath("//table[@id='resultTable']//tr/td[2]/a");
     By Addlog  = By.xpath("//input[@id='btnAdd' and @value='Add']");
     By logfield = By.xpath("//input[@id='addTracker_txtLog']");
     By commentfield  = By.xpath("//textarea[@id='addTracker_txtComment']");
     By savelog  = By.xpath("//input[@id='btnSave' and @value='Save']");
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
    public void KPIPage (){
        waitForElementToBeClickable(confgDropdown);
        performanceDriver.findElement(confgDropdown).click();
        waitForElementToBeClickable(KPI);
        performanceDriver.findElement(KPI).click();
    }

    public void Addpage () {
        waitForElementToBeClickable(Add);
        performanceDriver.findElement(Add).click();
    }

    public void KeyPerformanceIndicatorPage (String Name) {
        waitForElementToBeVisible(configureDropdown);
        performanceDriver.findElement(KeyPerformanceIndicator).sendKeys();
    }


    public void waitForElementToBeVisible(By locator){
        WebDriverWait wait = new WebDriverWait(performanceDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void Jobtitleselection () {
        waitForElementToBeClickable(jobtitlefeild);
        performanceDriver.findElement(jobtitlefeild).click();

        waitForElementToBeClickable(jobtitle);
        performanceDriver.findElement(jobtitle).click();
    }
    public void saveA () {
        waitForElementToBeClickable(saveButton);
        performanceDriver.findElement(saveButton).click();
    }

    public void Mytrakersbutton () {
        waitForElementToBeClickable(Mytrakers);
        performanceDriver.findElement(Mytrakers).click();
    }

    public void view () {
        waitForElementToBeClickable(viewbutton);
        performanceDriver.findElement(viewbutton).click();
    }

    public void Addlogbutton () {
        waitForElementToBeClickable(Addlog);
        performanceDriver.findElement(Addlog).click();
    }

    public void log (String Name) {
        waitForElementToBeVisible(logfield);
        performanceDriver.findElement(logfield).sendKeys();
    }
    public void comment (String Name) {
        waitForElementToBeVisible(commentfield);
        performanceDriver.findElement(commentfield).sendKeys();
    }

    public void save () {
        waitForElementToBeClickable(saveButton);
        performanceDriver.findElement(saveButton).click();
    }

    public WebElement getReviewTable() {
        return performanceDriver.findElement(reviewTable);
    }
}
