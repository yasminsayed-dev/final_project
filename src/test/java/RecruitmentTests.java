

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RecruitmentPage;

import java.io.IOException;

public class RecruitmentTests extends BaseTest {
    private RecruitmentPage recruitmentPage;


    @Test(testName = "Login with valid data Test Case", priority = 1, dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void login(String username, String password) throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        //saveScreenshot("screenshotDashBoardPIM.png");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard should be displayed after login");
    }

    @Test(priority = 2)
    public void testVerifyRecruitmentSection() {
        loginPage.clickRecruitmentModule();
        // Assertion is missing here, you can add based on visible elements like Candidates or Vacancies
    }

    @Test(priority = 3)
    public void testAddCandidate() {
        recruitmentPage.goToCandidates();
        recruitmentPage.addCandidate("John", "Doe", "john.doe@example.com");
        // Assertion placeholder
    }

    @Test (priority = 4)
    public void testAddVacancy() {
        recruitmentPage.goToVacancies();
        recruitmentPage.addVacancy("Software Developer", "Lisa");
        // Assertion placeholder
    }
}
