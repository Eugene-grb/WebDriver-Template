package web.elements;

import org.openqa.selenium.WebElement;

public class BaseElement {

    protected WebElement webElement;

    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }

    /** Получение оборачиваемого веб элемента
    // Получив оборачиваемый элемент, можно вызвать его методы
    // Например, getText() */
    public WebElement getWebElement() {
        return webElement;
    }
}
