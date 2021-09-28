package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class Button extends  BaseElement {

    public Button(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        WaitHelper.visibilityOfElement(webElement);
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
