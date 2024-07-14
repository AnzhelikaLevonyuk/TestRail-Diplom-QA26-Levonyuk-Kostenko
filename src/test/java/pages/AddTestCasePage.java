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
    private static final By TYPE = By.cssSelector("[data-testid ='editCaseTypeId'] + div");
    private static final By PRIORITY = By.cssSelector("[data-testid ='editCasePriorityId'] + div");
    private static final By STATUS = By.cssSelector("[data-testid ='addEditCaseStatusId'] + div");

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(new Button(driver, CREATE_TEST_CASE_BUTTON)));
    }

    @Step("Create new test-case")
    public void createTestCase(TestCase testCase) {

        new Input(driver, TITLE).setValue(testCase.getTitle());

        new DropDown(driver, driver.findElement(TYPE)).selectByVisibleText(testCase.getType().getName());
        new DropDown(driver, driver.findElement(PRIORITY)).selectByVisibleText(testCase.getPriority().getName());
        new DropDown(driver, driver.findElement(STATUS)).selectByVisibleText(testCase.getStatus().getName());
        new TextArea(driver, driver.findElement(PRECONDITION)).setValue(testCase.getPreconditions());
        new TextArea(driver, driver.findElement(STEPS)).setValue(testCase.getSteps());
        new TextArea(driver, driver.findElement(EXPECTED_RESULT)).setValue(testCase.getExpectedResult());
    }

    @Step("Click 'Create Test Case' button")
    public void clickCreateTestCaseButton() {
        new Button(driver, CREATE_TEST_CASE_BUTTON).click();
    }
}
