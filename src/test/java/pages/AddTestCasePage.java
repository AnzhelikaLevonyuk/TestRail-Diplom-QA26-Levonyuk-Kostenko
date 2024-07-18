package pages;

import decorators.Button;
import decorators.DropDown;
import decorators.Input;
import decorators.TextArea;
import io.qameta.allure.Step;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddTestCasePage extends BaseDashboardPage {
    private static final String TITLE = "addEditCaseTitle";
    private static final By PRECONDITION = By.cssSelector("#custom_preconds_attachments_wrapper  div.form-control");
    private static final By STEPS = By.cssSelector("#custom_steps_attachments_wrapper div.form-control");
    private static final By EXPECTED_RESULT = By.cssSelector("#custom_expected_attachments_wrapper div.form-control");
    private static final String CREATE_TEST_CASE_BUTTON = "addTestCaseButton";
    private static final By TEMPLATE = By.cssSelector("[data-testid ='editCaseTemplateId'] + div");
    private static final By TYPE = By.cssSelector("[data-testid ='editCaseTypeId'] + div");
    private static final By PRIORITY = By.cssSelector("[data-testid ='editCasePriorityId'] + div");
    private static final By STATUS = By.cssSelector("[data-testid ='addEditCaseStatusId'] + div");
    private static final By ADD_STEP_BUTTON = By.cssSelector("[data-testid ='addEditCaseAddStep']");
    private static final By STEPS_STEP_DESCRIPTION = By.cssSelector("[data-testid ='addEditCaseStepContent']");
    private static final By STEPS_EXPECTED_RESULT = By.cssSelector("[data-testid ='addEditCaseStepExpected']");
    private final static String ERROR_ESTIMATE_MESSAGE = "//div[contains(@class, 'message-error') and text()='Field Estimate is not in a valid time span format.']";
    private final String estimateInput = "editCaseEstimate";

    public AddTestCasePage(WebDriver driver)
    {
        super(driver);
    }

    @Override
    public void isPageOpened()
    {
        wait.until(ExpectedConditions.visibilityOf(new Button(driver, CREATE_TEST_CASE_BUTTON)));
    }

    @Step("Create new test-case")
    public void createTestCase(TestCase testCase)
    {
        new Input(driver, TITLE).setValue(testCase.getTitle());
        new DropDown(driver, driver.findElement(TEMPLATE)).selectByVisibleText(testCase.getTemplate().getName());
        new DropDown(driver, driver.findElement(TYPE)).selectByVisibleText(testCase.getType().getName());
        new DropDown(driver, driver.findElement(PRIORITY)).selectByVisibleText(testCase.getPriority().getName());
        new DropDown(driver, driver.findElement(STATUS)).selectByVisibleText(testCase.getStatus().getName());
        new TextArea(driver, driver.findElement(PRECONDITION)).setValue(testCase.getPreconditions());
        if (testCase.getEstimateInput() != null) {
            new Input(driver, this.estimateInput).setValue(testCase.getEstimateInput());
        }
        new TextArea(driver, driver.findElement(STEPS)).setValue(testCase.getSteps());
        new TextArea(driver, driver.findElement(EXPECTED_RESULT)).setValue(testCase.getExpectedResult());
    }

    @Step("Create new test-case")
    public void createTestCaseSteps(TestCase testCase)
    {
        new Input(driver, TITLE).setValue(testCase.getTitle());
        new DropDown(driver, driver.findElement(TEMPLATE)).selectByVisibleText(testCase.getTemplate().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new DropDown(driver, driver.findElement(TYPE)).selectByVisibleText(testCase.getType().getName());
        new DropDown(driver, driver.findElement(PRIORITY)).selectByVisibleText(testCase.getPriority().getName());
        new DropDown(driver, driver.findElement(STATUS)).selectByVisibleText(testCase.getStatus().getName());
        new TextArea(driver, driver.findElement(PRECONDITION)).setValue(testCase.getPreconditions());
        new Button(driver, ADD_STEP_BUTTON).click();
        new TextArea(driver, driver.findElement(STEPS_STEP_DESCRIPTION)).setValue(testCase.getStepDescription());
        new TextArea(driver, driver.findElement(STEPS_EXPECTED_RESULT)).setValue(testCase.getStepsExpectedResult());
    }

    @Step("Click 'Create Test Case' button")
    public void clickCreateTestCaseButton()
    {
        new Button(driver, CREATE_TEST_CASE_BUTTON).click();
    }

    @Step("Editing test Case")
    public void editTestCase(TestCase testCase)
    {
        new Input(driver, TITLE).clearValue();
        new Input(driver, TITLE).setValue(testCase.getTitle());
        if (testCase.getType() != null) {
            new DropDown(driver, driver.findElement(TYPE)).selectByVisibleText(testCase.getType().getName());
        }
        if (testCase.getPriority() != null) {
            new DropDown(driver, driver.findElement(PRIORITY)).selectByVisibleText(testCase.getPriority().getName());
        }
        if (testCase.getStatus() != null) {
            new DropDown(driver, driver.findElement(STATUS)).selectByVisibleText(testCase.getStatus().getName());
        }
        new TextArea(driver, driver.findElement(PRECONDITION)).clearValue();
        new TextArea(driver, driver.findElement(PRECONDITION)).setValue(testCase.getPreconditions());
        new TextArea(driver, driver.findElement(STEPS)).clearValue();
        new TextArea(driver, driver.findElement(STEPS)).setValue(testCase.getSteps());
        new TextArea(driver, driver.findElement(EXPECTED_RESULT)).clearValue();
        new TextArea(driver, driver.findElement(EXPECTED_RESULT)).setValue(testCase.getExpectedResult());
    }
    @Step("Get Expected Error Message")
    public String getExpectedErrorMessage()
    {
        return driver.findElement(By.xpath(ERROR_ESTIMATE_MESSAGE)).getText();
    }
}
