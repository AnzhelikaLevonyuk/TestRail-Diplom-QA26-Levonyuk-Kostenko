package pages;

import decorators.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BaseDashboardPage {
    private static final String ADD_TEST_CASE_BUTTON = "sidebarCasesAdd";

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click 'Add Test Case' button")
    public void clickAddTestCaseButton() {
        new Button(driver, ADD_TEST_CASE_BUTTON).click();
    }

}