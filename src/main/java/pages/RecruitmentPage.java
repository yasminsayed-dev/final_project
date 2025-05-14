package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RecruitmentPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By recruitmentTab = By.xpath("//span[text()='Recruitment']/parent::a");
    private final By candidatesOption = By.xpath("//a[text()='Candidates']");
    private final By addButton = By.xpath("//button[text()=' Add ']");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By email = By.xpath("//div[label[text()='Email']]//input");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By vacanciesOption = By.xpath("//a[text()='Vacancies']");
    private final By addVacancyButton = By.xpath("(//button[text()=' Add '])[2]");
    private final By vacancyName = By.xpath("//label[text()='Vacancy Name']/following::input[1]");
    private final By jobTitleDropdown = By.xpath("//label[text()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]");
    private final By jobTitleOption = By.xpath("//div[@role='option']/span[text()='Software Engineer']");
    private final By hiringManager = By.xpath("//label[text()='Hiring Manager']/following::input[1]");

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickRecruitmentTab() {
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentTab)).click();
    }

    public boolean isCandidatesOptionVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(candidatesOption)).isDisplayed();
    }

    public boolean isVacanciesOptionVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(vacanciesOption)).isDisplayed();
    }

    public void navigateToCandidates() {
        clickRecruitmentTab();
        wait.until(ExpectedConditions.elementToBeClickable(candidatesOption)).click();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
    }

    public void enterFirstName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(name);
    }

    public void enterLastName(String name) {
        driver.findElement(lastName).sendKeys(name);
    }

    public void enterEmail(String emailText) {
        driver.findElement(email).sendKeys(emailText);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
    }

    public void navigateToVacancies() {
        clickRecruitmentTab();
        wait.until(ExpectedConditions.elementToBeClickable(vacanciesOption)).click();
    }

    public void clickAddVacancyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addVacancyButton)).click();
    }

    public void enterVacancyName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(vacancyName)).sendKeys(name);
    }

    public void selectJobTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(jobTitleDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(jobTitleOption)).click();
    }

    public void enterHiringManager(String manager) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(hiringManager)).sendKeys(manager);
    }
}