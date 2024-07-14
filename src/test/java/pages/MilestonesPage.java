package pages;

import decorators.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MilestonesPage extends BaseDashboardPage {
    private static final By MILESTONE_LIST = By.cssSelector(".hoverSensitive");
    private static final String ADD_MILESTONE = "navigationMilestonesAdd";
    private static final String DELETE_MILESTONE_CONTAINER = "//td/a[text()='%s']//ancestor::div[@id=\"completed\"]//a[@class = \"deleteLink\"]";
    private static final String MILESTONES_CONTAINER = "//td/a[text() = '%s']";

    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Add milestone' button")
    public void clickAddMilestoneButton() {
        new Button(driver, ADD_MILESTONE).click();
    }

    @Step("Click Delete button near {milestoneName}")
    public void clickDeleteMilestone(String milestoneName) {
        driver.findElement(By.xpath(String.format(DELETE_MILESTONE_CONTAINER, milestoneName))).click();
    }

    @Step("Check {milestoneName} milestone in the list on Milestones page")
    public boolean isMilestoneCreated(String milestoneName) {
        List<WebElement> milestones = driver.findElements(MILESTONE_LIST);
        return milestones.stream().anyMatch(milestone -> milestone.getText().equals(milestoneName));
    }

    @Step("Open Milestone info page")
    public void openInfoPage(String milestoneName) {
        driver.findElement(By.xpath(String.format(MILESTONES_CONTAINER, milestoneName))).click();
    }

}
