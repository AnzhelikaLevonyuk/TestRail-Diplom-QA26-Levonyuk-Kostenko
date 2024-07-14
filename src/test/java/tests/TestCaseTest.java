package tests;

import models.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataGeneration;

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
}
