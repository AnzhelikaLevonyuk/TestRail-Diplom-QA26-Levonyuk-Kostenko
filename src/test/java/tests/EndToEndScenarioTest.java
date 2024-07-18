package tests;

import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.TestDataGeneration;

import java.io.File;

public class EndToEndScenarioTest extends BaseTest {

    @Test(groups = {"regression","userShouldBeLogin"}, description = "Full Workflow Test")
    public void completeTest()
    {
        project = TestDataGeneration.generateProject();
        Project updatedProject = TestDataGeneration.generateUpdateProject();
        milestone = TestDataGeneration.generateMilestone();
        testCase = TestDataGeneration.generateTestCase();
        File uploadFile = new File(PropertyReader.getProperty("filepath"));
        section = TestDataGeneration.generateSection();

        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);
        projectsPage.returnToDashboardTab();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.clickProjectsLink();
        projectsPage.clickEditProjectButton(project.getName());
        addProjectPage.editProject(updatedProject);
        projectsPage.returnToDashboardTab();
        dashboardPage.isPageOpened();
        dashboardPage.openProject(updatedProject.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCase(testCase);
        addTestCasePage.addAttachment(uploadFile);
        addTestCasePage.clickCreateTestCaseButton();
        testCaseInfoPage.isPageOpened();
        testCaseInfoPage.returnToDashboardTab();
        dashboardPage.isPageOpened();
        dashboardPage.openProject(updatedProject.getName());
        projectsPage.isPageOpened();
        projectsPage.clickMilestonesTab();
        milestonesPage.isPageOpened();
        milestonesPage.clickAddMilestoneButton();
        addMilestonePage.isPageOpened();
        addMilestonePage.createMilestone(milestone);
        addMilestonePage.clickCreateMilestoneButton();
        milestonesPage.isPageOpened();
        milestonesPage.returnToDashboardTab();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.clickProjectsLink();
        projectsPage.clickDeleteProjectButton(updatedProject.getName());
        confirmationModal.waitConfirmationDialogToDisplayed();
        confirmationModal.checkCheckbox();
        confirmationModal.clickDeleteButton();
        Assert.assertEquals(projectsPage.getSuccessMessage(), "Successfully deleted the project.");
        Assert.assertFalse(projectsPage.isProjectCreated(project.getName()));
    }
}
