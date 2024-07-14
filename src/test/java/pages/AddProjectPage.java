package pages;

import decorators.*;
import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddProjectPage extends BasePage {


    private static final String PROJECT_NAME = "addProjectNameInput";
    private static final String ANNOUNCEMENT = "addEditProjectAnnouncement";
    private static final String CHECK_BOX_SHOW_THE_ANNOUNCEMENT = "addEditProjectShowAnnouncement";
    private static final String CHECK_BOX_ENABLE_TEST_CASE_APPROVALS = "addEditProjectCaseStatusesEnabled";
    private static final String RADIO_BUTTON_SINGLE_REPOSITORY_FOR_ALL_CASES = "addEditProjectSuiteModeSingle";
    private static final String RADIO_BUTTON_SINGLE_REPOSITORY_WITH_BASE_LINE_SUPPORT = "addEditProjectSuiteModeSingleBaseline";
    private static final String RADIO_BUTTON_MULTIPLE_TEST = "addEditProjectSuiteModeMulti";
    private static final String ADD_PROJECT_BUTTON = "addEditProjectAddButton";
    private static final By PROJECTS_LINK = By.cssSelector("[data-testid = 'administrationSidebarProjects']");


    private static final By ERROR_MESSAGE = By.cssSelector("link + div");


    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(new Button(driver, ADD_PROJECT_BUTTON)));
    }

    @Step("Creating new project")
    public void createNewProject(Project project) {
        if (project.getName() != null) {
            new Input(driver, PROJECT_NAME).setValue(project.getName());
        }

        if (project.getAnnouncement() != null) {
            new TextArea(driver, ANNOUNCEMENT).setValue(project.getAnnouncement());
        }

        if (project.isShowAnnouncement()) {
            new CheckBox(driver, CHECK_BOX_SHOW_THE_ANNOUNCEMENT).check();
        }
        new RadioButton(driver, project.getProjectType().getId()).select();

        if (project.isEnableTestCaseApprovals()) {
            new CheckBox(driver, CHECK_BOX_ENABLE_TEST_CASE_APPROVALS).check();
        }
        new Button(driver, ADD_PROJECT_BUTTON).click();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Click Projects link in Administration")
    public void clickProjectsLink() {
        driver.findElement(PROJECTS_LINK).click();
    }

}
