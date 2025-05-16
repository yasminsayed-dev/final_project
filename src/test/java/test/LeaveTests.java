package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LeavePage;
import pages.LoginPage;

import java.io.IOException;


public class LeaveTests extends BaseTest {

    @Test(testName = "Login with valid data Test Case", priority = 1, dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void login(String username, String password) throws IOException {
        loginPage = new LoginPage(BaseTest.driver);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        saveScreenshot("screenshotDashBoardPIM.png");
        Assert.assertTrue(BaseTest.driver.getCurrentUrl().contains("dashboard"), "Dashboard should be displayed after login");
    }

    @Test(priority = 2)
    public void TC01_validLeaveSubmission() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.navigateToApplyLeave();
        leavePage.applyLeave("Annual", "2024-01-15", "2024-01-17");

        Assert.assertTrue(leavePage.isSuccessMessageVisible(), "Success message not displayed");
        Assert.assertEquals(leavePage.getLatestLeaveStatus(), "Pending Approval");
    }

    @Test (priority = 3)
    public void TC02_missingLeaveType() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.navigateToApplyLeave();
        leavePage.applyLeave(null, "2024-01-18", "2024-01-19");

        Assert.assertTrue(leavePage.getDateErrorCount() == 0, "Unexpected date errors");
        Assert.assertTrue(leavePage.getLatestLeaveStatus().contains("Required"), "Leave type error missing");
    }

    @Test( priority = 4)
    public void TC03_missingDates() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.navigateToApplyLeave();
        leavePage.applyLeave("Sick", null, null);

        Assert.assertEquals(leavePage.getDateErrorCount(), 2, "Date errors count mismatch");
    }

    @Test (priority = 5)
    public void TC07_singleDayLeave() {
        LeavePage leavePage = new LeavePage(driver);
        leavePage.navigateToApplyLeave();
        leavePage.applyLeave("Annual", "2024-01-25", "2024-01-25");

        Assert.assertTrue(leavePage.isSuccessMessageVisible(), "Success message not displayed");
        Assert.assertTrue(leavePage.getDurationText().contains("1 Day"), "Duration mismatch");
    }
}