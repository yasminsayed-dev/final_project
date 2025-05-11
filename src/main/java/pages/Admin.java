package pages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
public class Admin {



        WebDriver driver;

        @BeforeClass
        public void start() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }

        @Test(priority = 1)
        public void loginTest() throws InterruptedException {
            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");
            driver.findElement(By.cssSelector("button[type='submit']")).click();
            Thread.sleep(3000);
        }

        @Test(priority = 2)
        public void navigateToAdminPage() {
            WebElement adminTab = driver.findElement(By.xpath("//span[text()='Admin']"));
            adminTab.click();
        }

        @Test(priority = 3)
        public void searchUser() throws InterruptedException {
            Thread.sleep(2000);
            driver.findElement(By.xpath("//label[text()='Username']/../following-sibling::div/input")).sendKeys("Admin");
            driver.findElement(By.xpath("//label[text()='User Role']/../following-sibling::div//i")).click();
            WebElement userRoleOption = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Admin']"));
            userRoleOption.click();
            driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
            Thread.sleep(2000);
            WebElement firstResult = driver.findElement(By.xpath("//div[@class='oxd-table-body']//div[contains(text(),'Admin')]"));
            Assert.assertTrue(firstResult.isDisplayed(), "Admin user should be displayed in the result.");
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }

