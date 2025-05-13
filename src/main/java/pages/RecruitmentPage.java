package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentPage {
    WebDriver recruitmentDriver;

    // Locators
    By RECRUITMENT_TAB = By.xpath("//span[text()='Recruitment']/parent::a");
    By CANDIDATES_OPTION = By.xpath("//a[text()='Candidates']");
    By ADD_BUTTON = By.xpath("//button[text()=' Add ']");
    By FIRST_NAME = By.name("firstName");
    By LAST_NAME = By.name("lastName");
    By EMAIL = By.xpath("//label[text()='Email']/following::input[1]");
    By SAVE_BUTTON = By.xpath("//button[@type='submit']");
    By VACANCIES_OPTION = By.xpath("//a[text()='Vacancies']");
    By ADD_VACANCY_BUTTON = By.xpath("//button[text()=' Add ']");
    By VACANCY_NAME = By.xpath("//label[text()='Vacancy Name']/following::input[1]");
    By HIRING_MANAGER = By.xpath("//label[text()='Hiring Manager']/following::input[1]");
    By JOB_TITLE_DROPDOWN = By.xpath("//label[text()='Job Title']/following::div[contains(@class,'oxd-select-text')][1]");
    By JOB_TITLE_OPTION = By.xpath("//div[@role='option']/span[contains(text(),'Software Engineer')]");

    public RecruitmentPage(WebDriver driver) {
        recruitmentDriver = driver;
    }

    // Actions
    public void goToRecruitmentTab() {
        recruitmentDriver.findElement(RECRUITMENT_TAB).click();
    }

    public void goToCandidates() {
        recruitmentDriver.findElement(CANDIDATES_OPTION).click();
    }

    public void addCandidate(String fName, String lName, String mail) {
        recruitmentDriver.findElement(ADD_BUTTON).click();
        recruitmentDriver.findElement(FIRST_NAME).sendKeys(fName);
        recruitmentDriver.findElement(LAST_NAME).sendKeys(lName);
        recruitmentDriver.findElement(EMAIL).sendKeys(mail);
        recruitmentDriver.findElement(SAVE_BUTTON).click();
    }

    public void goToVacancies() {
        goToRecruitmentTab();
        recruitmentDriver.findElement(VACANCIES_OPTION).click();
    }

    public void addVacancy(String vName, String manager) {
        recruitmentDriver.findElement(ADD_VACANCY_BUTTON).click();
        recruitmentDriver.findElement(VACANCY_NAME).sendKeys(vName);
        recruitmentDriver.findElement(JOB_TITLE_DROPDOWN).click();
        recruitmentDriver.findElement(JOB_TITLE_OPTION).click();
        recruitmentDriver.findElement(HIRING_MANAGER).sendKeys(manager);
        recruitmentDriver.findElement(SAVE_BUTTON).click();
    }
}