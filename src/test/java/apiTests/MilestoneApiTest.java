package apiTests;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.Milestone;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.TestDataGeneration;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MilestoneApiTest extends BaseApiTest {


    @Test(description = "this test checks creation of milestone by Api from JSON File")
    public void createMilestoneFromJsonFile() throws FileNotFoundException
    {
        String pathToJsonFile = System.getProperty("user.dir") + PropertyReader.getProperty("json.Milestone.dir");
        milestone = new Gson().fromJson(new FileReader(pathToJsonFile), Milestone.class);
        Response response = milestoneController.createMilestoneFromFile(milestone, projectId);
        Assert.assertEquals(200, response.getStatusCode());
        Milestone actualMilestone = response.getBody().as(Milestone.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualMilestone, milestone);
    }

    @Test(description = "this test checks creation of milestone by Api")
    public void createMilestone()
    {
        milestone = TestDataGeneration.generateSimpleMilestone();
        Response response = milestoneController.createMilestone(milestone, projectId);
        Assert.assertEquals(200, response.getStatusCode());
        Milestone actualMilestone = response.getBody().as(Milestone.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualMilestone, milestone);
    }

    @Test(description = "this test checks creation of milestone by Api", groups = "need create milestone")
    public void updateMilestone()
    {
        Response response = milestoneController.updateMilestone(milestone, milestoneId);
        Assert.assertEquals(200, response.getStatusCode());
        Milestone updatedMilestone = response.getBody().as(Milestone.class, ObjectMapperType.GSON);
        Assert.assertEquals(updatedMilestone, milestone);
    }

    @Test(description = "this test checks creation of milestone by Api", groups = "need create milestone")
    public void readMilestone()
    {
        Response response = milestoneController.getMilestone(milestone, milestoneId);
        Assert.assertEquals(200, response.getStatusCode());
        Milestone actualMilestone = response.getBody().as(Milestone.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualMilestone.getDescription(), milestone.getDescription());
    }
}