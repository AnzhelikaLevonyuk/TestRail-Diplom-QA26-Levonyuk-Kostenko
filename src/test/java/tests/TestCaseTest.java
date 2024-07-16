package tests;

import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;
import utils.TestDataGeneration;

import java.io.File;

public class TestCaseTest extends BaseTest {


    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new test case")
    public void createTestCase() {

        testCase = TestDataGeneration.generateTestCase();

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCase(testCase);
        addTestCasePage.clickCreateTestCaseButton();

        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully added the new test case. Add another");
        TestCase actualTestCase = testCaseInfoPage.getTestCaseInfo();
        Assert.assertEquals(actualTestCase, testCase);


    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new test case")
    public void createTestCaseSteps() {

        testCase = TestDataGeneration.generateTestCaseSteps();

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCaseSteps(testCase);
        addTestCasePage.clickCreateTestCaseButton();

        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully added the new test case. Add another");
        TestCase actualTestCase = testCaseInfoPage.getTestCaseStepsInfo();
        Assert.assertEquals(actualTestCase, testCase);


    }

    @Test(groups = {"smoke", "userShouldBeLogin", "ProjectShouldBeCreated"}, description = "Creating new test case with attachment")
    public void createTestCaseWithAttachment() {
        testCase = TestDataGeneration.generateTestCase();
        File uploadFile = new File(PropertyReader.getProperty("filename"));

        dashboardPage.isPageOpened();
        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickAddTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.createTestCase(testCase);
        addTestCasePage.addAttachment(uploadFile);
        addTestCasePage.clickCreateTestCaseButton();

        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully added the new test case. Add another");
        Assert.assertTrue(testCaseInfoPage.isAttachmentDisplayed());
    }

    @Test(groups = {"regression", "userShouldBeLogin", "ProjectShouldBeCreated", "TestCaseShouldBeCreated"}, description = "Edit testcase")
    public void editTestCase()
    {
        TestCase updateTestCase = TestDataGeneration.generateUpdateTestCase();

        dashboardPage.openProject(project.getName());
        overviewProjectPage.isPageOpened();
        overviewProjectPage.clickTestCasesTab();
        testCasesPage.isPageOpened();
        testCasesPage.clickTestCaseLinkByName(testCase.getTitle());
        testCaseInfoPage.isPageOpened();
        testCaseInfoPage.clickEditTestCaseButton();
        addTestCasePage.isPageOpened();
        addTestCasePage.editTestCase(updateTestCase);
        addTestCasePage.clickCreateTestCaseButton();
        testCaseInfoPage.isPageOpened();

        Assert.assertEquals(testCaseInfoPage.getSuccessMessage(), "Successfully updated the test case.");
        TestCase actualTestCase = testCaseInfoPage.getTestCaseInfo();
        Assert.assertEquals(actualTestCase, updateTestCase);

    }

}
