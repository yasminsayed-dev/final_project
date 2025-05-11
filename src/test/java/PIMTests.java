
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIM;

import java.io.IOException;

public class PIMTests extends BaseTest {


    @Test(testName = "Login with valid data Test Case", priority = 1, dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void login(String username, String password) throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        //saveScreenshot("screenshotDashBoardPIM.png");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard should be displayed after login");
    }

    @Test(testName = "the PIM module opens Successfully",priority = 2)
    public void dashboard() throws IOException {
        PIMPage = loginPage.clickPIMModule();
        Assert.assertTrue(PIMPage.getEmployeeInfoHeader().isDisplayed(), "Employee Information header should be visible after login");
        // saveScreenshot("screenshotPIMModule.png");
    }

    @Test(testName = "search Employee",priority = 3, dataProvider = "searchData", dataProviderClass = TestDataProvider.class)
    public void searchEmployee(String employeeName) throws IOException {
        PIMPage.typeEmployeeName(employeeName);
        PIMPage.clickSearchButton();
        //saveScreenshot("screenshotSearchEmployee.png");
    }
    @Test(testName = "reset fields",priority = 4)
    public void resetFields() throws IOException {
        PIMPage.clickResetButton();
        //saveScreenshot("screenshotResetFields.png");
    }

    @Test(testName = "add Employee", priority = 5, dataProvider = "employeeData", dataProviderClass = TestDataProvider.class)
    public void addEmployee(String firstName, String lastName) throws IOException {
        PIMPage.clickAddButton();
        PIMPage.addEmployeeFields(firstName, lastName);
        PIMPage.clickSubmitButton();
        Assert.assertTrue( PIMPage.getAddEmployeeHeader().isDisplayed(), "Add Employee header should be visible after adding employee");
        //saveScreenshot("screenshotAddEmployee.png");
    }

    @Test(testName = "open optionalFields", priority = 6)
    public void optionalFields() throws IOException {
        loginPage.clickPIMModule();
        PIMPage.clickConfigDropdown();
        PIMPage.optionalFields();
        //saveScreenshot("screenshotOptionalFields.png");
    }

    @Test( testName = "logOut", priority = 7)
    public void logout() throws IOException {
        PIMPage.logout();
        //saveScreenshot("screenshotLogoutPIM.png");
    }


}
