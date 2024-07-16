package pages;

import decorators.Button;
import decorators.Input;
import decorators.TextArea;
import io.qameta.allure.Step;
import models.Section;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BaseDashboardPage {
    private static final String ADD_TEST_CASE_BUTTON = "sidebarCasesAdd";
    private static final String ADD_SECTION_BUTTON = "addSectionInline";
    private static final By SECTION_NAME = By.id("editSectionName");
    private static final By SECTION_DESCRIPTION = By.id("editSectionDescription_display");
    private static final By ADD_SECTION = By.id("editSectionSubmit");

    private static final String TEST_CASE_TITLE = "//tbody/tr/following-sibling::tr[starts-with(@id, 'row')]//span[text()='%s']";

    public TestCasesPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Click 'Add Test Case' button")
    public void clickAddTestCaseButton()
    {
        new Button(driver, ADD_TEST_CASE_BUTTON).click();
    }

    @Step("Click 'Add Section' button")
    public void clickAddSectionButton()
    {
        new Button(driver, ADD_SECTION_BUTTON).click();
    }

    @Step("Creating new Section")
    public void createSection(Section section)
    {
        new Input(driver, SECTION_NAME).setValue(section.getName());
        new TextArea(driver, SECTION_DESCRIPTION).setValue(section.getDescription());
    }

    @Step("Click 'Add Section' button")
    public void clickAddSection()
    {
        new Button(driver, ADD_SECTION).click();
    }

    @Step("Click TestCase Link by name = '{testCaseName}'")
    public void clickTestCaseLinkByName(String testCaseTitle)
    {
        driver.findElement(By.xpath(String.format(TEST_CASE_TITLE, testCaseTitle))).click();
    }
}