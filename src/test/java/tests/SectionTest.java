package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.TestDataGeneration;

import java.io.File;

public class SectionTest extends BaseTest {

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new Section")
    public void createSection() {

        section = TestDataGeneration.generateSection();
        File uploadFile = new File(PropertyReader.getProperty("filename"));

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddSectionButton();
        testCasesPage.createSection(section);
        testCasesPage.addAttachment(uploadFile);
        testCasesPage.clickAddSection();

        Assert.assertTrue(testCaseInfoPage.isSectionCreated(section.getName()));


    }
}
