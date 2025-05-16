package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeavePage {
    private final WebDriver driver;
    private final WebDriverWait wait;


    // Existing locators
    private final By leaveMenu = By.xpath("//span[text()='Leave']/parent::a");
    private final By applyLeaveTab = By.xpath("//a[contains(@href,'applyLeave')]");
    private final By leaveTypeDropdown = By.xpath("//label[text()='Leave Type']/following::div[1]");
    private final By leaveTypeOptions = By.xpath("//div[@role='option']/span");
    private final By fromDateInput = By.xpath("//label[text()='From Date']/following::input");
    private final By toDateInput = By.xpath("//label[text()='To Date']/following::input");
    private final By applyButton = By.xpath("//button[text()=' Apply ']");
    private final By successToast = By.xpath("//div[contains(@class,'oxd-toast--success')]");
    private final By myLeaveListTab = By.xpath("//a[contains(@href,'viewMyLeaveList')]");
    private final By statusCell = By.xpath("//div[contains(@class,'oxd-table-cell')][6]//div");
    private final By dateErrors = By.xpath("//span[text()='Required']");

    public LeavePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

    public void navigateToApplyLeave() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(applyLeaveTab)).click();
    }

    public void applyLeave(String leaveType, String fromDate, String toDate) {
        if (leaveType != null) selectLeaveType(leaveType);
        if (fromDate != null) setDate(fromDateInput, fromDate);
        if (toDate != null) setDate(toDateInput, toDate);
        wait.until(ExpectedConditions.elementToBeClickable(applyButton)).click();
    }

    private void selectLeaveType(String type) {
        wait.until(ExpectedConditions.elementToBeClickable(leaveTypeDropdown)).click();
        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(leaveTypeOptions));
        options.stream()
                .filter(e -> e.getText().equalsIgnoreCase(type))
                .findFirst()
                .orElseThrow()
                .click();
    }

    private void setDate(By locator, String date) {
        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(locator));
        field.clear();
        field.sendKeys(date);
    }

    public boolean isSuccessMessageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successToast)).isDisplayed();
    }

    public String getLatestLeaveStatus() {
        navigateToMyLeaveList();
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(statusCell))
                .get(0)
                .getText();
    }

    private void navigateToMyLeaveList() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(myLeaveListTab)).click();
    }

    public int getDateErrorCount() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dateErrors)).size();
    }

    public Collection<Object> getDurationText() {
        return Collections.singleton(wait);
    }

}