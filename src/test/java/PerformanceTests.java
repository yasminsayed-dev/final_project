import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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


    @Test(priority = 1)
    public void loginAsManager() throws IOException {
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLogin();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("dashboard"));
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
    public void KpI() throws IOException {
        performancePage.KPIPage();
        performancePage.Addpage();
        performancePage.KeyPerformanceIndicatorPage("jade");
        performancePage.Jobtitleselection();
        performancePage.saveA();
        //Assert.assertTrue(performancePage.isReviewSaved());
        //saveScreenshot("03_addReview.png");
    }

    @Test(priority = 4)
    public void myTrackers() throws IOException {
        performancePage.Mytrakersbutton();
        performancePage.view();
        performancePage.Addlogbutton();
        performancePage.log("test");
        performancePage.comment("Nice");
        performancePage.save();
        //Assert.assertTrue(performancePage.isReviewVisibleToEmployee());
        //saveScreenshot("04_employeeView.png");
    }

    @Test(priority = 5)
    public void reviewPersistsAfterRefresh() throws IOException {
        driver.navigate().refresh();
        //Assert.assertTrue(performancePage.isReviewPresent());
        //saveScreenshot("05_reviewPersist.png");
    }

    @Test( testName = "logOut", priority = 6)
    public void logout() throws IOException {
        PIMPage.logout();
        //saveScreenshot("screenshotLogoutPIM.png");
    }

}
