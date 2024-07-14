package pages;

import decorators.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseDashboardPage extends BasePage {

    private static final By DASHBOARD_TAB = By.id("navigation-dashboard");
    private static final By RETURN_TO_DASHBOARD = By.id("navigation-dashboard-top");
    private static final By MILESTONES_TAB = By.id("navigation-milestones");
    private static final By TEST_CASES_TAB = By.id("navigation-suites");


    public BaseDashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isPageOpened() {
        wait.until(ExpectedConditions.elementToBeClickable(new Button(driver, TEST_CASES_TAB)));
    }

    @Step("Click 'Milestone' tab")
    public void clickMilestonesTab() {
        driver.findElement(MILESTONES_TAB).click();
    }

    @Step("Click 'Test Case' tab")
    public void clickTestCasesTab() {
        driver.findElement(TEST_CASES_TAB).click();
    }

    public boolean isDashboardTabDisplayed() {
        try {
            driver.findElement(DASHBOARD_TAB).isDisplayed();

        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    @Step("Click 'Dashboard' tab")
    public void returnToDashboardTab() {
        if (isDashboardTabDisplayed()) {
            driver.findElement(DASHBOARD_TAB).click();
        } else {
            driver.findElement(RETURN_TO_DASHBOARD).click();
        }
    }
}
