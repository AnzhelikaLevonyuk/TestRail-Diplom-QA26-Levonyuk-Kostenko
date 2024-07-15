package tests;

import models.Milestone;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class MilestonesTest extends BaseTest {


    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new milestone")
    public void createMilestone() {

        milestone = TestDataGeneration.generateMilestone();

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        projectsPage.isPageOpened();
        projectsPage.clickMilestonesTab();
        milestonesPage.isPageOpened();
        milestonesPage.clickAddMilestoneButton();
        addMilestonePage.isPageOpened();
        addMilestonePage.createMilestone(milestone);
        addMilestonePage.clickCreateMilestoneButton();
        Assert.assertEquals(milestonesPage.getSuccessMessage(), "Successfully added the new milestone.");

        milestonesPage.openInfoPage(milestone.getName());
        Milestone actualMilestone = milestoneInfoPage.getMilestoneInfo();
        Assert.assertEquals(actualMilestone, milestone);
    }

    @Test(groups = {"regression", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new milestone without name")
    public void createMilestoneWithoutName() {
        milestone = Milestone.builder()
                .setName("").setMilestoneIsCompleted(true)
                .build();

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickMilestonesTab();
        milestonesPage.isPageOpened();
        milestonesPage.clickAddMilestoneButton();
        addMilestonePage.isPageOpened();
        addMilestonePage.createMilestoneWithoutName(milestone);
        addMilestonePage.clickCreateMilestoneButton();
        Assert.assertEquals(addMilestonePage.getErrorMessage(), "Field Name is a required field.");
    }

    @BeforeMethod(onlyForGroups = "createMilestone", alwaysRun = true)
    public void beforeCreateMilestone() {

        milestone = TestDataGeneration.generateMilestone();

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        projectsPage.clickMilestonesTab();
        milestonesPage.isPageOpened();
        milestonesPage.clickAddMilestoneButton();
        addMilestonePage.isPageOpened();
        addMilestonePage.createMilestone(milestone);
        addMilestonePage.clickCreateMilestoneButton();
        milestonesPage.returnToDashboardTab();
    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated", "createMilestone"}, description = "Delete milestone {milestoneName}")
    public void deleteMilestone() {
        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickMilestonesTab();
        milestonesPage.isPageOpened();
        milestonesPage.clickDeleteMilestone(milestone.getName());
        confirmationModal.waitConfirmationDialogToDisplayed();
        confirmationModal.clickDeleteButton();

        Assert.assertEquals(milestonesPage.getSuccessMessage(), "Successfully deleted the milestone (s).");
    }

}
