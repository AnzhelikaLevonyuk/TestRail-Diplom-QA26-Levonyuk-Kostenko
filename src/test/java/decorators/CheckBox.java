package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class CheckBox extends ElementDecorator {
    public CheckBox(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public CheckBox(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void check() {
        if (!element.isSelected()) {
            log.debug("Selecting checkbox {}", this.dataTestId );
            element.click();
        }
    }
}
