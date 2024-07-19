package apiTests;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Project;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

public class ProjectApiTest extends BaseApiTest {
    @Test
    public void createProject() {
        project = TestDataGeneration.generateProject();
        Response response = projectController.createProject(project);

        Assert.assertEquals(response.getStatusCode(),200);
        Project actualProject = response.getBody().as(Project.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualProject,project);
    }

    @Test
    public void deleteProject() {
        Response response = projectController.deleteProject(projectId);
        Assert.assertEquals(response.getStatusCode(),200);
    }
}