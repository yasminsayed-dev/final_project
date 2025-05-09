import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.* ;
import pages.LoginPage;
import pages.PIM;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

public class OrangeHrmTests {

    WebDriver driver;
    LoginPage loginPage;
    PIM PIMPage;


    private static final String SCREENSHOT_PATH = "./";

    private void saveScreenshot(String fileName) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        Files.copy(screenshotFile.toPath(), new File(SCREENSHOT_PATH + fileName).toPath());
    }

    @BeforeClass
    public void start() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }


    @Test(testName = "Login with valid data Test Case", priority = 1)
    public void login() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLogin();
        saveScreenshot("screenshotDashBoard.png");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard should be displayed after login");
    }


    @Test(testName = "the PIM module opens Successfully",priority = 2,dependsOnMethods = "login")
    public void dashboard() throws IOException {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='PIM']")));
        PIMPage = loginPage.clickPIMModule();
        Assert.assertTrue(
                PIMPage.getEmployeeInfoHeader().isDisplayed(),
                "Employee Information header should be visible after login"
        );
    }


    @Test(testName = "search Employee",priority = 3,dependsOnMethods = "dashboard")
    public void searchEmployee() throws IOException {
        PIMPage.typeEmployeeName("Laila");
        PIMPage.typeEmployeeId("12345");
        PIMPage.clickSearchButton();
        saveScreenshot("screenshotSearchEmployee.png");
    }
    @Test(testName = "reset fields",priority = 4,dependsOnMethods = "searchEmployee")
    public void resetFields() throws IOException {
        PIMPage.clickResetButton();
        saveScreenshot("screenshotResetFields.png");
    }

    @Test(dependsOnMethods = "dashboard", priority = 5)
    public void footer() throws IOException {
        PIMPage.getFooter().isDisplayed();
        saveScreenshot("screenshotFooter.png");
    }

    @Test(dependsOnMethods = "footer", priority = 6)
    public void pagination() throws IOException {
        PIMPage.clickSecondPageButton();
        saveScreenshot("screenshotPagination.png");
    }

    @Test(testName = "add Employee",dependsOnMethods = "resetFields", priority = 7)
    public void addEmployee() throws IOException {
        PIMPage.clickAddButton();
        PIMPage.addEmployeeFields("John", "Doe", "123456789");
        PIMPage.clickAddButton();
        Assert.assertTrue( PIMPage.getAddEmployeeHeader().isDisplayed(), "Add Employee header should be visible after adding employee");
        saveScreenshot("screenshotAddEmployee.png");
    }
    @Test(testName = "open optionalFields", priority = 8)
    public void optionalFields() throws IOException {
        dashboard();
        PIMPage.clickConfigDropdown();
        PIMPage.optionalFields();
        saveScreenshot("screenshotOptionalFields.png");
    }


    @Test( testName = "logOut",dependsOnMethods = "login", priority = 9)
    public void logout() throws IOException {
        PIMPage.logOut();
        saveScreenshot("screenshotLogout.png");
    }


    /*@AfterClass
    public void tearDown() {
        driver.quit();
    }*/
}
