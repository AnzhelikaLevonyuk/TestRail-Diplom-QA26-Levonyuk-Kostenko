package pages;

import models.Milestone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MilestoneInfoPage extends BaseDashboardPage {

    private static final By MILESTONE_NAME = By.cssSelector("[data-testid='testCaseContentHeaderTitle']");
    private static final By MILESTONE_DESCRIPTION = By.cssSelector(".markdown  p");
    private static final By MILESTONE_START_DATE = By.className("text-softer");

    public MilestoneInfoPage(WebDriver driver) {
        super(driver);
    }

    public Milestone getMilestoneInfo() {
        Milestone resultMilestone = Milestone.builder()
                .setName(driver.findElement(MILESTONE_NAME).getText())
                .setDescription(driver.findElement(MILESTONE_DESCRIPTION).getText())
                .setStartDate(driver.findElement(MILESTONE_START_DATE).getText())
                .build();

        return resultMilestone;
    }
}
