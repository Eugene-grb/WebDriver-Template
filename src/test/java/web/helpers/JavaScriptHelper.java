package web.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.drivers.WebDriverFactory;

public class JavaScriptHelper {

    private static final Logger logger = LogManager.getLogger(JavaScriptHelper.class);
    protected static JavascriptExecutor js;

    /** Инициализация исполнителя Js скриптов */
    public static void initJS() {
        js = (JavascriptExecutor) WebDriverFactory.getCurrentDriver();
    }

    /** Скролл страницы на заданное расстояние в пикселях по X и по Y */
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        js.executeScript(script);
    }

    /** Установка невидимости веб элемента */
    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        js.executeScript(script, element);
    }
}
