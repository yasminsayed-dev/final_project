import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
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

public class PIMTests {

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
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLogin();
        //saveScreenshot("screenshotDashBoard.png");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard should be displayed after login");
    }


    @Test(testName = "the PIM module opens Successfully",priority = 2)
    public void dashboard() throws IOException {
        PIMPage = loginPage.clickPIMModule();
        Assert.assertTrue(
               PIMPage.getEmployeeInfoHeader().isDisplayed(),
                "Employee Information header should be visible after login"
        );
       // saveScreenshot("screenshotDashBoard.png");
    }


    @Test(testName = "search Employee",priority = 3)
    public void searchEmployee() throws IOException {
        PIMPage.typeEmployeeName("Admin");
        PIMPage.clickSearchButton();
        //saveScreenshot("screenshotSearchEmployee.png");
    }
    @Test(testName = "reset fields",priority = 4)
    public void resetFields() throws IOException {
        PIMPage.clickResetButton();
        //saveScreenshot("screenshotResetFields.png");
    }

    @Test(testName = "add Employee", priority = 5)
    public void addEmployee() throws IOException {
        PIMPage.clickAddButton();
        PIMPage.addEmployeeFields("John", "Doe");
        PIMPage.clickSubmitButton();
        Assert.assertTrue( PIMPage.getAddEmployeeHeader().isDisplayed(), "Add Employee header should be visible after adding employee");
        //saveScreenshot("screenshotAddEmployee.png");
    }

    @Test(priority = 6)
    public void footer() throws IOException {
        loginPage.clickPIMModule();
        PIMPage.scrollToFooterElement();
        //Assert.assertTrue(PIMPage.getFooter().isDisplayed(), "Footer should be visible");
        //saveScreenshot("screenshotFooter.png");
    }

    @Test(/*dependsOnMethods = "footer",*/ priority = 7)
    public void pagination() throws IOException {
        PIMPage.clickSecondPageButton();
        //saveScreenshot("screenshotPagination.png");
    }


    @Test(testName = "open optionalFields", priority = 8)
    public void optionalFields() throws IOException {
        loginPage.clickPIMModule();
        PIMPage.clickConfigDropdown();
        PIMPage.optionalFields();
        //saveScreenshot("screenshotOptionalFields.png");
    }


    @Test( testName = "logOut", priority = 9)
    public void logout() throws IOException {
        PIMPage.logOut();
        //saveScreenshot("screenshotLogout.png");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
