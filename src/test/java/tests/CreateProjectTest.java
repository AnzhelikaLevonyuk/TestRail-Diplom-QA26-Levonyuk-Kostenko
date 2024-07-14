package tests;

import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class CreateProjectTest extends BaseTest {

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new project with all fields")
    public void createNewProject() {
        this.project = TestDataGeneration.generateProject();

        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);

        Assert.assertEquals(projectsPage.getSuccessMessage(), "Successfully added the new project.");
        Assert.assertTrue(projectsPage.isProjectCreated(project.getName()));

        projectsPage.clickOpenOverviewProjectPageButton(project.getName());
        Project actualProject = overviewProjectPage.getProjectInfo();
        Assert.assertEquals(actualProject, project);
    }

    @Test(groups = {"regression", "userShouldBeLogin"}, description = "Creating new project without name")
    public void createNewProjectWithoutName() {

        this.project = TestDataGeneration.generateProjectWithoutName();
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);
        Assert.assertEquals(addProjectPage.getErrorMessage(), "Field Name is a required field.");
    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Delete milestone {milestoneName}")
    public void deleteProject() {
        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.clickProjectsLink();
        projectsPage.clickDeleteProjectButton(project.getName());
        confirmationModal.waitConfirmationDialogToDisplayed();
        confirmationModal.checkCheckbox();
        confirmationModal.clickDeleteButton();

        Assert.assertEquals(milestonesPage.getSuccessMessage(), "Successfully deleted the project.");
        Assert.assertFalse(projectsPage.isProjectCreated(project.getName()));
    }

}
