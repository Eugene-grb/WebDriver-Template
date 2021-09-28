package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;
import web.elements.Table;
import web.helpers.WaitHelper;

public class SmartphoneProductPage extends BasePage {

    private Logger logger = LogManager.getLogger(SmartphoneProductPage.class);

    @FindBy(xpath = "//a[text()=\\\"Характеристики\\\"]")
    private WebElement linkCharacteristic;

    @FindBy(xpath = "//table")
    private WebElement tableCharacteristic;

    public SmartphoneProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Link linkCharacteristic() {
        WaitHelper.visibilityOfElement(tableCharacteristic);
        return  new Link(tableCharacteristic);
    }

    public Table tableCharacteristic() {
        WaitHelper.visibilityOfElement(tableCharacteristic);
        return new Table(tableCharacteristic);
    }
}
