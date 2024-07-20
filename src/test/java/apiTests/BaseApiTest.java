package apiTests;

import controllers.*;
import io.restassured.response.Response;
import models.Milestone;
import models.Plan;
import models.Project;
import models.Section;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.TestDataGeneration;

public abstract class BaseApiTest {
    ProjectController projectController = new ProjectController();
    protected Project project;
    protected int projectId;
    MilestoneController milestoneController = new MilestoneController();
    protected Milestone milestone;
    protected int milestoneId;
    SectionController sectionController = new SectionController();
    protected Section section;
    TestCaseController testCaseController = new TestCaseController();
    SuiteController suiteController = new SuiteController();
    PlanController planController = new PlanController();
    protected Plan plan;

    @BeforeMethod(onlyForGroups = "need create project", alwaysRun = true)
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

}
