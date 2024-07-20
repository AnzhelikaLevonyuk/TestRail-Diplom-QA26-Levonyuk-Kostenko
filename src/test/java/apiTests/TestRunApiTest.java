package apiTests;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import models.TestRun;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.TestDataGeneration;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestRunApiTest extends BaseApiTest {

    @Test(groups = {"need create milestone", "api"}, description = "this test checks creation of TestRun by Api from JSON File")
    public void createTestRunFromJsonFile() throws FileNotFoundException
    {
        String pathToJsonFile = System.getProperty("user.dir") + PropertyReader.getProperty("json.TestRun.dir");
        testRun = new Gson().fromJson(new FileReader(pathToJsonFile), TestRun.class);
        testRun.setMilestoneId(milestoneId);
        Response response = testRunController.createTestRun(testRun, projectId);
        Assert.assertEquals(200, response.getStatusCode());
        TestRun actualTestRun = response.getBody().as(TestRun.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualTestRun, testRun);
    }

    @Test(groups = {"need create milestone", "api"}, description = "this test checks creation of TestRun by Api")
    public void createTestRun()
    {
        testRun = TestDataGeneration.generateTestRun(milestoneId);
        Response response = testRunController.createTestRun(testRun, projectId);
        Assert.assertEquals(200, response.getStatusCode());
        TestRun actualTestRun = response.getBody().as(TestRun.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualTestRun, testRun);
    }

    @Test(groups = {"api", "need create testRun", "need create milestone"}, description = "this test get testRun by Api")
    public void readTestRun()
    {
        Response response = testRunController.getTestRun(testRun, testRunId);
        Assert.assertEquals(200, response.getStatusCode());
        TestRun actualTestRun = response.getBody().as(TestRun.class, ObjectMapperType.GSON);
        Assert.assertEquals(actualTestRun.getDescription(), testRun.getDescription());
    }


    @Test(groups = {"api", "need create testRun", "need create milestone"}, description = "this test checks updating of TestRun by Api")
    public void updateTestRun()
    {
        Response response = testRunController.updateTestRun(testRun, testRunId);
        Assert.assertEquals(200, response.getStatusCode());
        TestRun updatedTestRun = response.getBody().as(TestRun.class, ObjectMapperType.GSON);
        Assert.assertEquals(updatedTestRun, testRun);
    }

    @Test(groups = {"api", "need create testRun", "need create milestone"}, description = "this test delete testRun by Api")
    public void deleteTestRun()
    {
        Response response = testRunController.deleteTestRun(testRun, testRunId);
        Assert.assertEquals(200, response.getStatusCode());
        boolean isTestRunDeleted = response.getBody().asString().isEmpty();
        Assert.assertTrue(isTestRunDeleted);
    }
}
