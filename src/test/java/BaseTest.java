import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import pages.LoginPage;
import pages.PIM;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    private static final String SCREENSHOT_PATH = "./";

    LoginPage loginPage;
    PIM PIMPage;
    /** Load driver and navigate to login page */
    @BeforeClass
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }
//    @BeforeClass(alwaysRun = true)
//    public void initPages() {
//        // loginPage is already instantiated by BaseTest.start()
//        PIMPage = loginPage.clickPIMModule();
//    }

    /** Quit the driver after all tests */
    /*@AfterClass
    public void tearDown() {
        driver.quit();
    }*/

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