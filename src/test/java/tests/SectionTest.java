package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class SectionTest extends BaseTest {

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new Section")
    public void createSection() {

        section = TestDataGeneration.generateSection();

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddSectionButton();
        testCasesPage.createSection(section);
        testCasesPage.addAttachment();
        testCasesPage.clickAddSection();

        Assert.assertTrue(testCaseInfoPage.isSectionCreated(section.getName()));


    }
}
