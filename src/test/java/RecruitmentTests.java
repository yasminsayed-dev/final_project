import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RecruitmentPage;

import java.io.IOException;

public class RecruitmentTests extends BaseTest {



    @Test(testName = "Login with valid data Test Case", priority = 1, dataProvider = "loginData", dataProviderClass = TestDataProvider.class)
    public void login(String username, String password) throws IOException {
        loginPage = new LoginPage(driver);
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        loginPage.clickLogin();
        //saveScreenshot("screenshotDashBoardPIM.png");
//        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Dashboard should be displayed after login");
    }

    @Test(priority = 2)
    public void testVerifyRecruitmentSection() {
        // 1. loginPage is already constructed by your BaseTest.start
    loginPage.clickRecruitmentModule();
        // 2. verify the URL or the presence of both tabs
//        Assert.assertTrue(driver.getCurrentUrl().contains("/recruitment"),
//                "Expected to land in the recruitment module");
//        Assert.assertTrue(recruitmentPage.isCandidatesTabVisible(),
//                "Candidates tab should be visible");
//        Assert.assertTrue(recruitmentPage.isVacanciesTabVisible(),
//                "Vacancies tab should be visible");
    }

    @Test(priority = 3)
    public void testAddCandidate() {
        recruitmentPage.goToCandidates();
        recruitmentPage.addCandidate("John", "Doe", "john.doe@example.com");
//        Assert.assertTrue(recruitmentPage.isCandidateAdded("john.doe@example.com"),
//                "New candidate should appear in the list");
    }

    @Test(priority = 4)
    public void testAddVacancy() {
        loginPage.clickRecruitmentModule();
        recruitmentPage.goToVacancies();
        recruitmentPage.addVacancy("Software Developer", "Lisa");
//        Assert.assertTrue(recruitmentPage.addVacancy("Software Developer",
//                "New vacancy should appear in the list");
    }
}
