import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.PIM;
import pages.PerformancePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class PerformanceTests extends BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    PIM PIMPage;
    PerformancePage performancePage;


    @Test(priority = 1)
    public void loginAsManager() throws IOException {
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLogin();
        //saveScreenshot("01_loginManager.png");
        //Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test(priority = 2)
    public void openPerformanceModule() throws IOException {
        performancePage = loginPage.clickPerformanceModule();
       // Assert.assertTrue(performancePage.isReviewPageVisible());
        //saveScreenshot("02_openPerformance.png");
    }

    @Test(priority = 3)
    public void addPerformanceReview() throws IOException {
        performancePage.clickAddReview();
        performancePage.fillReviewForm("John Doe", "Admin", "80", "Great performance");
        performancePage.saveReview();
        //Assert.assertTrue(performancePage.isReviewSaved());
        //saveScreenshot("03_addReview.png");
    }

    @Test(priority = 4)
    public void employeeViewReview() throws IOException {
        PIMPage.logout();
        loginPage.typeUsername("employeeUsername"); // استبدلي باليوزر الحقيقي للموظف
        loginPage.typePassword("employeePassword");
        loginPage.clickLogin();
        performancePage = loginPage.clickPerformanceModule();
        //Assert.assertTrue(performancePage.isReviewVisibleToEmployee());
        //saveScreenshot("04_employeeView.png");
    }

    @Test(priority = 5)
    public void reviewPersistsAfterRefresh() throws IOException {
        driver.navigate().refresh();
        //Assert.assertTrue(performancePage.isReviewPresent());
        //saveScreenshot("05_reviewPersist.png");
    }

    @Test(priority = 6)
    public void errorOnIncompleteForm() throws IOException {
        PIMPage.logout();
        loginAsManager();
        performancePage = loginPage.clickPerformanceModule();
        performancePage.clickAddReview();
        performancePage.leaveRequiredFieldsEmptyAndSave();
        //Assert.assertTrue(performancePage.isValidationErrorShown());
        //saveScreenshot("06_incompleteFormError.png");
    }

    @Test(priority = 7)
    public void employeeCannotAddReview() throws IOException {
        PIMPage.logout();
        loginPage.typeUsername("employeeUsername");
        loginPage.typePassword("employeePassword");
        loginPage.clickLogin();
        performancePage = loginPage.clickPerformanceModule();
        //Assert.assertFalse(performancePage.isAddButtonVisible());
        //saveScreenshot("07_employeeCannotAdd.png");
    }

    @Test(priority = 8)
    public void managerEditsReview() throws IOException {
        loginPage.clickLogin();
        PIMPage.logout();
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLogin();
        performancePage = loginPage.clickPerformanceModule();
        performancePage.editReviewScore("90");
        //Assert.assertTrue(performancePage.isReviewUpdated());
        //saveScreenshot("08_editReview.png");
    }

    @Test(priority = 9)
    public void preventDuplicateReview() throws IOException {
        performancePage.clickAddReview();
        performancePage.fillReviewForm("John Doe", "2024-01-01", "80", "Duplicate attempt");
        performancePage.saveReview();
        //Assert.assertTrue(performancePage.isDuplicateWarningShown());
       // saveScreenshot("09_preventDuplicate.png");
    }

}
