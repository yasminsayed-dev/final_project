package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminTests {
    private WebDriver driver;
    private WebDriverWait wait;

    // ───────────────────────────────  Setup / Teardown  ───────────────────────────────
    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // ─────────────────────────────────────  Test  ─────────────────────────────────────
    @Test
    public void searchForBuiltInAdminUser() {

        /* 1. Login */
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("username")))
                .sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        /* 2. Navigate to Admin */
        wait.until(ExpectedConditions
                        .elementToBeClickable(By.cssSelector("a[href*='admin']")))
                .click();

        // Username
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")))
                .sendKeys("Admin");

        // User Role ▸ Admin
        driver.findElement(By.xpath("//label[.='User Role']/following::div[@role='combobox'][1]"))
                .click();
        wait.until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//div[@role='option' and .='Admin']")))
                .click();

        // Status ▸ Enabled
        driver.findElement(By.xpath("//label[.='Status']/following::div[@role='combobox'][1]"))
                .click();
        wait.until(ExpectedConditions
                        .elementToBeClickable(By.xpath("//div[@role='option' and .='Enabled']")))
                .click();

        // Search
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        /* 4. Assertion */
        WebElement userCell = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@role='cell' and .='Admin']")));

        Assert.assertTrue(userCell.isDisplayed(),
                "User 'Admin' should appear in the search results.");
    }
}
