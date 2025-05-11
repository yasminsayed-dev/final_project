import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import pages.LoginPage;
import pages.PIM;
import pages.PerformancePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    private static final String SCREENSHOT_PATH = "./";

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
}