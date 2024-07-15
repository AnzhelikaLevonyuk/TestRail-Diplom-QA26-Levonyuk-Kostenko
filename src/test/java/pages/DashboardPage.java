package pages;

import decorators.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    private static final String PROJECT_CONTAINER = "//div[@class ='table']//a[text() = '%s']";
    private static final By NAVIGATION_USERNAME = By.cssSelector(".navigation-username");
    private static final String ADD_PROJECT_LINK = "sidebarProjectsAddButton";
    private static final By DASHBOARD_LINK = By.id("navigation-dashboard");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(new Button(driver, ADD_PROJECT_LINK)));
    }

    public boolean isUserNameDisplayed() {
        return driver.findElement(NAVIGATION_USERNAME).isDisplayed();
    }

    @Step("Click 'Add Project' link")
    public void clickAddProjectLink() {
        new Button(driver, ADD_PROJECT_LINK).click();
    }

    @Step("Click 'Dashboard' link")
    public void clickDashboardLink() {
        new Button(driver, DASHBOARD_LINK).click();
    }

    @Step("Open {projectName} project")
    public void openProject(String projectName) {
        driver.findElement(By.xpath(String.format(PROJECT_CONTAINER, projectName))).click();
    }
}
