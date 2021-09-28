package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class CheckBox extends BaseElement {

    public CheckBox(WebElement webElement) {
        super(webElement);
    }

    /** Установка флажка */
    public void setChecked(boolean value) {
        WaitHelper.clickabilityOfElement(webElement);
        if (value != isChecked()) {
            webElement.click();
        }
    }

    /** Проверка, что флажок установлен */
    public boolean isChecked() {
        return webElement.isSelected();
    }
}
