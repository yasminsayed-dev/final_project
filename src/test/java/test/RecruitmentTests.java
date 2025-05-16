package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RecruitmentPage;
import java.io.IOException;

public class RecruitmentTests extends BaseTest {

    @Test(priority = 1)
    public void testVerifyRecruitmentSection() throws IOException {
        loginPage = new LoginPage(BaseTest.driver);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        loginPage.clickLogin();

        RecruitmentPage recruitmentPage = new RecruitmentPage(BaseTest.driver);
        recruitmentPage.clickRecruitmentTab();

        boolean candidatesExists = recruitmentPage.isCandidatesOptionVisible();
        boolean vacanciesExists = recruitmentPage.isVacanciesOptionVisible();

        Assert.assertTrue(candidatesExists, "Candidates option not visible");
        Assert.assertTrue(vacanciesExists, "Vacancies option not visible");


    }

    @Test(priority = 2)
    public void testAddCandidate() throws IOException {
        RecruitmentPage recruitmentPage = new RecruitmentPage(BaseTest.driver);
        recruitmentPage.navigateToCandidates();
        recruitmentPage.clickAddButton();

        recruitmentPage.enterFirstName("John");
        recruitmentPage.enterLastName("Doe");
        recruitmentPage.enterEmail("john.doe@example.com");

        recruitmentPage.clickSaveButton();

    }

    @Test(priority = 3)
    public void testAddVacancy() throws IOException {
        RecruitmentPage recruitmentPage = new RecruitmentPage(BaseTest.driver);
        recruitmentPage.navigateToVacancies();
        recruitmentPage.clickAddVacancyButton();

        recruitmentPage.enterVacancyName("Software Developer");
        recruitmentPage.selectJobTitle();
        recruitmentPage.enterHiringManager("Lisa");

        recruitmentPage.clickSaveButton();

    }
}
