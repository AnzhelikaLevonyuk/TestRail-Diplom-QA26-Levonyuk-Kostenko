package decorators;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RadioButton extends ElementDecorator {
    public RadioButton(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void select() {
        if (!element.isSelected()) {
            log.debug("Clicking radiobutton,with data-testid = {}", this.dataTestId);
            element.click();
        }
    }
}
