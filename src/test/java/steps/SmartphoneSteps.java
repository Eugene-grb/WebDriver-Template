package steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import web.drivers.BrowserName;
import web.drivers.WebDriverFactory;
import web.pages.SmartphonesPage;
import web.pages.StartPage;

public class SmartphoneSteps {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SmartphoneSteps.class);

    @Дано("Запущен браузер и открыта Главная страница ДНС")
    public void startDriverAndOpenStartPage() {
        driver = WebDriverFactory.getDriver(BrowserName.fromString("Chrome"));
        logger.info("Start Driver!");
        driver.get("https://www.dns-shop.ru/");
        logger.info("Open Dns start page");
    }

    @Когда("Выполнен переход на страницу Смартфоны")
    public void openSmartphonesPage() {
        StartPage startPage = new StartPage(driver);
        startPage.linkYes().click();
        startPage.linkSmartsAndGadgets().focusOnLink();
        startPage.linkSmarts().click();
        logger.info("Переход на страницу каталога смартфонов");
    }

    @Тогда("Проверить: В заголовке страницы отображается текс Смартфоны")
    public void assertTitle() {
        SmartphonesPage smartphonesPage = new SmartphonesPage(driver);
        Assertions.assertTrue(smartphonesPage.getPageTitle().contains("Смартфоны"));
        if (driver != null) {
            driver.quit();
            logger.info("Driver Stop!");
        }
    }
}
