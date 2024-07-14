package pages;

import enums.TestCasePriority;
import enums.TestCaseStatus;
import enums.TestCaseType;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCaseInfoPage extends BasePage {


    private static final By TITLE = By.cssSelector("[data-testid ='testCaseContentHeaderTitle']");
    private static final By TYPE = By.cssSelector("td[data-testid ='testCaseViewCellTypeId']");
    private static final By PRIORITY = By.cssSelector("td[data-testid='testCaseViewCellPriorityId']");
    private static final By STATUS = By.id("cell_status");
    private static final By PRECONDITIONS = By.xpath("//span[text() = 'Preconditions']/../following-sibling::div[@class='field-content'][1]//p");
    private static final By STEPS = By.xpath("//span[text() = 'Steps']/../following-sibling::div[@class='field-content'][1]//p");
    private static final By EXPECTED_RESULT = By.xpath("//span[text() = 'Expected Result']/../following-sibling::div[@class='field-content']//p");


    public TestCaseInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(STATUS));
    }

    public TestCase getTestCaseInfo() {
        TestCase resultTestCase = new TestCase.TestCaseBuilder(driver.findElement(TITLE).getText())
                .setType(TestCaseType.getFromName(driver.findElement(TYPE).getText().replace("Type\n", "")))
                .setPriority(TestCasePriority.getFromName(driver.findElement(PRIORITY).getText().replace("Priority\n", "")))
                .setStatus(TestCaseStatus.getFromName(driver.findElement(STATUS).getText().replace("Status\n", "")))
                .setPreconditions(driver.findElement(PRECONDITIONS).getText())
                .setSteps(driver.findElement(STEPS).getText())
                .setExpectedResult(driver.findElement(EXPECTED_RESULT).getText())
                .build();
        return resultTestCase;
    }
}
