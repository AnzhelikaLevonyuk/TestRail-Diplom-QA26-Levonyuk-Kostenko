package pages;

import decorators.Button;
import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewProjectPage extends BaseDashboardPage {
    private static final By ADD_MILESTONE_BUTTON = By.id("navigation-overview-addmilestones");
    private static final By PROJECT_NAME = By.cssSelector("[data-testid='testCaseContentHeaderTitle']");
    private static final By PROJECT_ANNOUNCEMENT = By.cssSelector("[data-testid='projectAnnouncement']");


    public OverviewProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Add Milestone' button")
    public MilestonesPage clickAddMilestoneButton() {
        new Button(driver, ADD_MILESTONE_BUTTON).click();
        return new MilestonesPage(driver);
    }

    public Project getProjectInfo() {
        Project resultProject;
        if (driver.findElement(PROJECT_ANNOUNCEMENT).isDisplayed()) {
            resultProject = new Project.ProjectBuilder(driver.findElement(PROJECT_NAME).getText())
                    .setAnnouncement(driver.findElement(PROJECT_ANNOUNCEMENT).getText())
                    .build();
        } else {
            resultProject = new Project.ProjectBuilder(driver.findElement(PROJECT_NAME).getText())
                    .build();
        }
        return resultProject;
    }

}
