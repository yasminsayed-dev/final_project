import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.PIM;
import pages.PerformancePage;
import pages.RecruitmentPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public abstract class BaseTest {
    protected static WebDriver driver;
    public static WebDriverWait wait;
    private static final String SCREENSHOT_PATH = "./";


    RecruitmentPage recruitmentPage;
    LoginPage loginPage;
    PIM PIMPage;
    PerformancePage performancePage;
    /** Load driver and navigate to login page */
    @BeforeClass
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        loginPage = new LoginPage(driver);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    // Quit the driver after all tests
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /** Captures and saves a screenshot with the given filename */
    protected void saveScreenshot(String fileName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(src.toPath(), new File(SCREENSHOT_PATH + fileName).toPath());
        } catch (IOException e) {
            // Log or re‑throw as needed
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }
    }




    public void enterText(By locator, String text, String name) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        field.clear();
        field.sendKeys(text);
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clickElement(By locator, String name) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }


}
