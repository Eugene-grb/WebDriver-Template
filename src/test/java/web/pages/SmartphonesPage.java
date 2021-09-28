package web.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.elements.*;
import web.helpers.WaitHelper;

public class SmartphonesPage extends BasePage {

    private Logger logger = LogManager.getLogger(SmartphonesPage.class);


    // Шапка
    @FindBy(xpath = "//header")
    private WebElement mainBlock;

    // Блок с чекбоксами "Производитель"
    @FindBy(xpath = "//span[text()=\"Производитель\"]/parent::a/following-sibling::div//div[@class=\"ui-checkbox-group ui-checkbox-group_list\"]")
    private WebElement divCompany;

    // Аккордеон "Объем оперативной памяти"
    @FindBy(xpath = "//div[@class=\"ui-list-controls ui-collapse ui-collapse_list\"]//span[contains(text(), \"Объем оперативной памяти\")]")
    private WebElement accordeonRAM;

    // Блок с чекбоксами "Объем оперативной памяти"
    @FindBy(xpath = "//span[text()=\"Объем оперативной памяти\"]/parent::a/following-sibling::div//div[@class=\"ui-checkbox-group ui-checkbox-group_list\"]")
    private WebElement divRAM;

    // Кнопка "Применить"
    @FindBy(xpath = "//button[contains(text(), \"Применить\")]")
    private WebElement buttonApply;

    // Аккордеон "Сортировка"
    @FindBy(xpath = "//span[contains(text(), \"Сортировка:\")]/following::a")
    private WebElement accordeonSort;

    // Блок с переключателями "Сортировка"
    @FindBy(xpath = "(//div[@class=\"top-filter__radio-list ui-radio top-filter__popover\"])[1]")
    private WebElement divSort;

    // Ссылка на первый продукт в списке
    @FindBy(xpath = "(//a[contains(@class, \"catalog-product__name\")])[1]")
    private WebElement linkFirstProduct;


    public SmartphonesPage(WebDriver driver) {
        super(driver);
    }

    // ***** Получение обернутых веб элементов *****
    // 1. Шапка
    public MainBlock mainBlock() {
        return new MainBlock(mainBlock);
    }
    // 2. Фильтры
    // Чекбокс "Производитель"
    public CheckBox checkBoxCompany(String company) {
        return new CheckBox(findCheckBoxCompany(company));
    }
    // Поиск чекбокса "Производитель"
    private WebElement findCheckBoxCompany(String company) {
        WaitHelper.visibilityOfElement(divCompany);
        return divCompany.findElement(By.xpath("./label/span[contains(text(), \"" + company + "\")]"));
    }

    // Фильтр "Объем оперативной памяти"
    public Accordion accordeonRAM() {
        return new Accordion(accordeonRAM);
    }
    // Чекбокс "Объем оперативной памяти"
    public CheckBox checkBoxRAM(String ram) {
        return new CheckBox(findCheckBoxRAM(ram));
    }
    // Поиск чекбокса "Объем оперативной памяти"
    private WebElement findCheckBoxRAM(String ram) {
        WaitHelper.visibilityOfElement(divRAM);
        return divRAM.findElement(By.xpath("./label/span[contains(text(), \"" + ram + "\")]"));
    }

    // Кнопка Применить
    public Button buttonApply() {
        return new Button(buttonApply);
    }

    // Аккордеон "Сортировка"
    public Accordion accordeonSort() {
        return new Accordion(accordeonSort);
    }
    // Переключатель "Сортировка"
    public RadioButton radioButtonSort(String sort) {
        return new RadioButton(findRadioButtonSort(sort));
    }
    // Поиск переключателя "Сортировка"
    private WebElement findRadioButtonSort(String sort) {
        WaitHelper.visibilityOfElement(divSort);
        return divSort.findElement(By.xpath("//span[contains(text(), \"" + sort + "\")]"));
    }

    // 4. Ссылка на первый продукт в списке
    public Link linkFirstProduct() {
        WaitHelper.clickabilityOfElement(linkFirstProduct);
        return new Link(linkFirstProduct);
    }

}
