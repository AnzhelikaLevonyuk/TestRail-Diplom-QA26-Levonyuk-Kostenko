package apiTests;

import controllers.MilestoneController;
import controllers.ProjectController;
import controllers.TestRunController;
import io.restassured.response.Response;
import models.Milestone;
import models.Project;
import models.TestRun;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.TestDataGeneration;

public abstract class BaseApiTest {
    ProjectController projectController = new ProjectController();
    protected Project project;
    public int projectId;
    MilestoneController milestoneController = new MilestoneController();
    protected Milestone milestone;
    public int milestoneId;
    TestRunController testRunController = new TestRunController();
    protected TestRun testRun;
    public int testRunId;

    @BeforeMethod(alwaysRun = true)
    public void beforeCreateProject() {
        project = TestDataGeneration.generateProject();
        Response response = projectController.createProject(project);
        projectId = response.getBody().jsonPath().getInt("id");
    }

    @AfterMethod(alwaysRun = true)
    public void afterDeleteProject() {
        projectController.deleteProject(projectId);
    }

    @BeforeMethod(alwaysRun = true, onlyForGroups = "need create milestone", dependsOnMethods = "beforeCreateProject")
    public void beforeCreateMilestone() {
        milestone = TestDataGeneration.generateSimpleMilestone();
        Response response = milestoneController.createMilestone(milestone, projectId);
        milestoneId = response.getBody().jsonPath().getInt("id");
    }
    @BeforeMethod(alwaysRun = true, onlyForGroups = "need create testRun", dependsOnMethods = "beforeCreateMilestone")
    public void beforeCreateTestRun() {
        testRun = TestDataGeneration.generateTestRun(milestoneId);
        Response response = testRunController.createTestRun(testRun, projectId);
        testRunId = response.getBody().jsonPath().getInt("id");
    }
}
