package pages;

import enums.TestCasePriority;
import enums.TestCaseStatus;
import enums.TestCaseType;
import io.qameta.allure.Step;
import models.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.PropertyReader;

import java.util.List;

public class TestCaseInfoPage extends BasePage {


    private static final By TITLE = By.cssSelector("[data-testid ='testCaseContentHeaderTitle']");
    private static final By TYPE = By.cssSelector("td[data-testid ='testCaseViewCellTypeId']");
    private static final By PRIORITY = By.cssSelector("td[data-testid='testCaseViewCellPriorityId']");
    private static final By STATUS = By.id("cell_status");
    private static final By PRECONDITIONS = By.xpath("//span[text() = 'Preconditions']/../following-sibling::div[@class='field-content'][1]//p");
    private static final By STEPS = By.xpath("//span[text() = 'Steps']/../following-sibling::div[@class='field-content'][1]//p");
    private static final By EXPECTED_RESULT = By.xpath("//span[text() = 'Expected Result']/../following-sibling::div[@class='field-content']//p");
    private static final By STEPS_EXPECTED_RESULT = By.cssSelector(".step-content + .hidden-vertical  div p");
    private static final By STEPS_DESCRIPTION = By.xpath("//div[@class= 'hidden-vertical']/div/p");

    private static final String ATTACHMENT = "//div[contains(@title, '%s')]";
    private static final By SECTION_LIST = By.cssSelector(".groupTreeContainer a span");


    public TestCaseInfoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(STATUS));
    }

    public TestCase getTestCaseInfo() {
        TestCase resultTestCase = TestCase.builder()
                .setTitle(driver.findElement(TITLE).getText())
                .setType(TestCaseType.getFromName(driver.findElement(TYPE).getText().replace("Type\n", "")))
                .setPriority(TestCasePriority.getFromName(driver.findElement(PRIORITY).getText().replace("Priority\n", "")))
                .setStatus(TestCaseStatus.getFromName(driver.findElement(STATUS).getText().replace("Status\n", "")))
                .setPreconditions(driver.findElement(PRECONDITIONS).getText())
                .setSteps(driver.findElement(STEPS).getText())
                .setExpectedResult(driver.findElement(EXPECTED_RESULT).getText())
                .build();
        return resultTestCase;
    }

    public TestCase getTestCaseStepsInfo() {
        TestCase resultTestCase = TestCase.builder()
                .setTitle(driver.findElement(TITLE).getText())
                .setType(TestCaseType.getFromName(driver.findElement(TYPE).getText().replace("Type\n", "")))
                .setPriority(TestCasePriority.getFromName(driver.findElement(PRIORITY).getText().replace("Priority\n", "")))
                .setStatus(TestCaseStatus.getFromName(driver.findElement(STATUS).getText().replace("Status\n", "")))
                .setPreconditions(driver.findElement(PRECONDITIONS).getText())
                .setStepDescription(driver.findElement(STEPS_DESCRIPTION).getText())
                .setStepsExpectedResult(driver.findElement(STEPS_EXPECTED_RESULT).getText())
                .build();
        return resultTestCase;
    }

    public boolean isAttachmentDisplayed() {
        return driver.findElement(By.xpath(String.format(ATTACHMENT, PropertyReader.getProperty("filename")))).isDisplayed();
    }

    @Step("Check {sectionName} in the list")
    public boolean isSectionCreated(String sectionName) {
        List<WebElement> sectionLists = driver.findElements(SECTION_LIST);
        return sectionLists.stream().anyMatch(section -> section.getText().equals(sectionName));
    }
}
