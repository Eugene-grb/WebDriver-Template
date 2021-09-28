package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;

public class StartPage extends BasePage {

    private Logger logger = LogManager.getLogger(StartPage.class);

    private final String URL = "https://www.dns-shop.ru/";

    // КНОПКА "ДА" В АЛЕРТЕ ГОРОДА
    @FindBy(xpath = "//a[contains(@rel, 'nofollow noopener')]")
    private WebElement linkYes;

    // ССЫЛКА "СМАРТФОНЫ И ГАДЖЕТЫ"
    @FindBy(xpath = "//a[@class='ui-link menu-desktop__root-title' and contains(text(),'Смартфоны и гаджеты')]")
    private WebElement linkSmartsAndGadgets;

    // ССЫЛКА "СМАРТФОНЫ"
    @FindBy(xpath = "//*[@class='ui-link menu-desktop__second-level']/descendant-or-self::*[text()='Смартфоны']")
    private WebElement linkSmarts;

    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Link linkYes() {
        return new Link(linkYes);
    }

    public Link linkSmartsAndGadgets() {
        return new Link(linkSmartsAndGadgets);
    }

    public Link linkSmarts() {
        return new Link(linkSmarts);
    }
}
