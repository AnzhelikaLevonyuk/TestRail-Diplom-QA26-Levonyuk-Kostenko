package tests;

import modals.ConfirmationModal;
import models.Milestone;
import models.Project;
import models.TestCase;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.PropertyReader;
import utils.TestDataGeneration;

@Listeners({InvokedListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected AddProjectPage addProjectPage;
    protected ProjectsPage projectsPage;
    protected MilestonesPage milestonesPage;
    protected AddMilestonePage addMilestonePage;
    protected TestCasesPage testCasesPage;
    protected AddTestCasePage addTestCasePage;
    protected TestCaseInfoPage testCaseInfoPage;
    protected ConfirmationModal confirmationModal;
    protected OverviewProjectPage overviewProjectPage;
    protected MilestoneInfoPage milestoneInfoPage;
    protected Project project;
    protected Milestone milestone;
    protected TestCase testCase;


    @BeforeMethod(alwaysRun = true)
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        addProjectPage = new AddProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
        milestonesPage = new MilestonesPage(driver);
        addMilestonePage = new AddMilestonePage(driver);
        testCasesPage = new TestCasesPage(driver);
        addTestCasePage = new AddTestCasePage(driver);
        testCaseInfoPage = new TestCaseInfoPage(driver);
        confirmationModal = new ConfirmationModal(driver);
        overviewProjectPage = new OverviewProjectPage(driver);
        milestoneInfoPage = new MilestoneInfoPage(driver);


        loginPage.open();
    }

    @BeforeMethod(onlyForGroups = "userShouldBeLogin", alwaysRun = true)
    public void userShouldBeLogIn() {
        loginPage.isPageOpened();
        loginPage.login(PropertyReader.getProperty("email"), PropertyReader.getProperty("password"));
    }

    @BeforeMethod(dependsOnMethods = {"setUp", "userShouldBeLogIn"}, onlyForGroups = "ProjectShouldBeCreated", alwaysRun = true)
    public void beforeCreateProject() {
        project = TestDataGeneration.generateProject();

        dashboardPage.isPageOpened();
        dashboardPage.clickAddProjectLink();
        addProjectPage.isPageOpened();
        addProjectPage.createNewProject(project);
        projectsPage.returnToDashboardTab();
        dashboardPage.isPageOpened();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
