package apiTests;

import controllers.ProjectController;
import io.restassured.response.Response;
import models.Project;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.TestDataGeneration;

public abstract class BaseApiTest {
    ProjectController projectController = new ProjectController();
    protected Project project;
    public int projectId;

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

}
