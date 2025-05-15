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

    @Test(priority = 1)
    public void loginAsManager() throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLogin();
        saveScreenshot("01_loginManager.png");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test(priority = 2)
    public void openPerformanceModule() throws IOException {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("dashboard"));
        performancePage = loginPage.clickPerformanceModule();

        saveScreenshot("02_openPerformance.png");
    }

    @Test(priority = 3)
    public void KpI() throws IOException {
        performancePage.KPIPage();
        performancePage.Addpage();
        performancePage.KeyPerformanceIndicatorPage("jade");
        performancePage.Jobtitleselection();
        performancePage.saveA();
        saveScreenshot("03_addReview.png");
    }

    @Test(priority = 4)
    public void myTrackers() throws IOException {
        performancePage.Mytrakersbutton();
        performancePage.view();
        performancePage.Addlogbutton();
        performancePage.log("test");
        performancePage.comment("Nice");
        performancePage.save();
        saveScreenshot("04_employeeView.png");
    }
        @Test( testName = "logOut", priority = 6)
    public void logout() throws IOException {
        PIMPage.logout();
        saveScreenshot("screenshotLogoutPIM.png");
    }

}
