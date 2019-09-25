package eReportP24.pages;

import com.codeborne.selenide.SelenideElement;
import eReportP24.entity.j3001001.J3001001DataItem;
import eReportP24.entity.j3001001.PersonsItem;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Log4j
public class J3001001Page {

    private SelenideElement importBtn = $(By.xpath("(//input[@value='Імпортувати'])[1]"));
    private SelenideElement editBtn = $(By.xpath("(//input[@value='Редагувати'])[1]"));
    private SelenideElement saveBtn = $(By.xpath("(//input[@value='Зберегти'])[1]"));
    private SelenideElement cancelBtn = $(By.xpath("(//input[@value='Скасувати'])[1]"));
    private SelenideElement sendBtn = $(By.xpath("(//input[@value='Підписати і надіслати'])[1]"));

    /***** Головна форма *****/
    private SelenideElement numberPage = $(By.name("HPAGES"));
    private SelenideElement codeERDPOU = $(By.name("HTIN"));
    private SelenideElement companyName = $(By.name("HNAME"));
    private SelenideElement typeStart = $(By.name("H01"));
    private SelenideElement typeEnd = $(By.name("H02"));
    private SelenideElement addBtn = $(By.xpath("(//input[@class='button_add'])[last()]"));
    private SelenideElement deleteBtn = $(By.className("button_del"));
    private SelenideElement formationDate = $(By.name("HFILL"));
    private SelenideElement rowsCount = $(By.name("R011G1"));
    private SelenideElement bossPassport = $(By.name("HKBOS"));
    private SelenideElement boss = $(By.name("HBOS"));
    private SelenideElement accountantPassport = $(By.name("HKBUH"));
    private SelenideElement accountant = $(By.name("HBUH"));


    @Step("Редактирование документа (заполним все поля)")
    public J3001001Page editDocument(J3001001DataItem j3001001DataItem) {
        editBtn.shouldBe(visible).click();
        numberPage.setValue(j3001001DataItem.getNumberOfList());
        codeERDPOU.setValue(j3001001DataItem.getCodeERDPOU());
        companyName.setValue(j3001001DataItem.getCompanyName());
        selectType(j3001001DataItem.getType());
        fillAllPersons(j3001001DataItem.getPersons());
        formationDate.setValue(j3001001DataItem.getFormationDate());
//        rowsCount.setValue(j3001001DataItem.getRowsCount());
        bossPassport.setValue(j3001001DataItem.getBossPassport());
        boss.setValue(j3001001DataItem.getBoss());
        accountantPassport.setValue(j3001001DataItem.getAccountantPassport());
        accountant.setValue(j3001001DataItem.getAccountant());
        return this;
    }

    @Step("Редактирование документа (заполним все поля)")
    public J3001001Page checkDocument(J3001001DataItem j3001001DataItem) {
        numberPage.shouldHave(exactValue(j3001001DataItem.getNumberOfList()));
        codeERDPOU.shouldHave(exactValue(j3001001DataItem.getCodeERDPOU()));
        companyName.shouldHave(exactValue(j3001001DataItem.getCompanyName()));
        checkType(j3001001DataItem.getType());
        checkAllPersons(j3001001DataItem.getPersons());
        formationDate.shouldHave(exactValue(j3001001DataItem.getFormationDate()));
        rowsCount.shouldHave(exactValue(String.valueOf(j3001001DataItem.getPersons().size())));
        bossPassport.shouldHave(exactValue(j3001001DataItem.getBossPassport()));
        boss.shouldHave(exactValue(j3001001DataItem.getBoss()));
        accountantPassport.shouldHave(exactValue(j3001001DataItem.getAccountantPassport()));
        accountant.shouldHave(exactValue(j3001001DataItem.getAccountant()));
        return this;
    }

    @Step("Заполним всех работников")
    public void fillAllPersons(List<PersonsItem> persons) {
        for (int i = 0; i < persons.size(); i++) {
            if (i > 0) addBtn.shouldBe(visible).click();
            fillCategory(i + 1, persons.get(i).getCategory());
            fillRegistrationCardNumber(i + 1, persons.get(i).getRegistrationNumber());
            fillSecondName(i + 1, persons.get(i).getSecondName());
            fillFirstName(i + 1, persons.get(i).getFirstName());
            fillThirdName(i + 1, persons.get(i).getThirdName());
            fillOrderNumber(i + 1, persons.get(i).getOrderNumber());
            fillPublicationOrderDate(i + 1, persons.get(i).getPublicationOrderDate());
            fillStartWorkDate(i + 1, persons.get(i).getStartDateWork());
        }
    }

    @Step("Проверим всех работников")
    public void checkAllPersons(List<PersonsItem> persons) {
        for (int i = 0; i < persons.size(); i++) {
            checkCategory(i + 1, persons.get(i).getCategory());
            checkRegistrationCardNumber(i + 1, persons.get(i).getRegistrationNumber());
            checkSecondName(i + 1, persons.get(i).getSecondName());
            checkFirstName(i + 1, persons.get(i).getFirstName());
            checkThirdName(i + 1, persons.get(i).getThirdName());
            checkOrderNumber(i + 1, persons.get(i).getOrderNumber());
            checkPublicationOrderDate(i + 1, persons.get(i).getPublicationOrderDate());
            checkStartWorkDate(i + 1, persons.get(i).getStartDateWork());
        }
    }

    /***** Для работы с добавлением работников *****/

    @Step("Выберем тип")
    public J3001001Page selectType(String type) {
        if (type.equalsIgnoreCase("початкове")) {
            typeStart.shouldBe(visible).click();
        } else if (type.equalsIgnoreCase("скасовуюче")) {
            typeEnd.shouldBe(visible).click();
        }
        return this;
    }

    @Step("Заполним \"Порядковый номер\" для строки №{rowNum}")
    public J3001001Page fillOrdinalNumber(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1ROWNUM__row%d']", rowNum))).setValue(value);
        return this;
    }

    @Step("Заполним \"Категорія особи\" для строки №{rowNum}")
    public J3001001Page fillCategory(int rowNum, String value) {
        $(By.xpath(String.format("//select[@name='T1RXXXXG4__row%d']", rowNum))).selectOption(value);
        return this;
    }

    @Step("Заполним \"Реєстраційний номер облікової картки\" для строки №{rowNum}")
    public J3001001Page fillRegistrationCardNumber(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG5S__row%d']", rowNum))).setValue(value);
        return this;
    }

    @Step("Заполним \"Прізвище застрахованої особи\" для строки №{rowNum}")
    public J3001001Page fillSecondName(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG61S__row%d']", rowNum))).setValue(value);
        return this;
    }

    @Step("Заполним \"Ім'я застрахованої особи\" для строки №{rowNum}")
    public J3001001Page fillFirstName(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG62S__row%d']", rowNum))).setValue(value);
        return this;
    }

    @Step("Заполним \"По батькові застрахованої особи\" для строки №{rowNum}")
    public J3001001Page fillThirdName(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG63S__row%d']", rowNum))).setValue(value);
        return this;
    }

    @Step("Заполним \"Номер наказу\" для строки №{rowNum}")
    public J3001001Page fillOrderNumber(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG7S__row%d']", rowNum))).setValue(value);
        return this;
    }

    @Step("Заполним \"Дата видання наказу\" для строки №{rowNum}")
    public J3001001Page fillPublicationOrderDate(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG8D__row%d']", rowNum))).setValue(value);
        return this;
    }

    @Step("Заполним \"Дата початку роботи\" для строки №{rowNum}")
    public J3001001Page fillStartWorkDate(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG9D__row%d']", rowNum))).setValue(value);
        return this;
    }

    /***** Для проверки данных добавленых работников *****/

    @Step("Выберем тип")
    public J3001001Page checkType(String type) {
        if (type.equalsIgnoreCase("початкове")) {
            typeStart.shouldHave(attribute("checked"));
        } else if (type.equalsIgnoreCase("скасовуюче")) {
            typeEnd.shouldHave(attribute("checked"));
        }
        return this;
    }

    @Step("Проверим \"Порядковый номер\" для строки №{rowNum}")
    public J3001001Page checkOrdinalNumber(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1ROWNUM__row%d']", rowNum))).shouldHave(value(value));
        return this;
    }

    @Step("Проверим \"Категорія особи\" для строки №{rowNum}")
    public J3001001Page checkCategory(int rowNum, String value) {
        $(By.xpath(String.format("//select[@name='T1RXXXXG4__row%d']", rowNum))).shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверим \"Реєстраційний номер облікової картки\" для строки №{rowNum}")
    public J3001001Page checkRegistrationCardNumber(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG5S__row%d']", rowNum))).shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверим \"Прізвище застрахованої особи\" для строки №{rowNum}")
    public J3001001Page checkSecondName(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG61S__row%d']", rowNum))).shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверим \"Ім'я застрахованої особи\" для строки №{rowNum}")
    public J3001001Page checkFirstName(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG62S__row%d']", rowNum))).shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверим \"По батькові застрахованої особи\" для строки №{rowNum}")
    public J3001001Page checkThirdName(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG63S__row%d']", rowNum))).shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверим \"Номер наказу\" для строки №{rowNum}")
    public J3001001Page checkOrderNumber(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG7S__row%d']", rowNum))).shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверим \"Дата видання наказу\" для строки №{rowNum}")
    public J3001001Page checkPublicationOrderDate(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG8D__row%d']", rowNum))).shouldHave(exactValue(value));
        return this;
    }

    @Step("Проверим \"Дата початку роботи\" для строки №{rowNum}")
    public J3001001Page checkStartWorkDate(int rowNum, String value) {
        $(By.xpath(String.format("//input[@name='T1RXXXXG9D__row%d']", rowNum))).shouldHave(exactValue(value));
        return this;
    }

    @Step("А сохраним-ка этот документ")
    public J3001001Page saveDocument() {
        saveBtn.click();
        try {
            $(By.xpath("//span[text()='Так']/..")).waitUntil(visible, 4 * 1000);
            $(By.xpath("//span[text()='Так']/..")).click();
        } catch (Throwable e) {
            log.info("Документ сохранился без ошибок");
        }
        return this;
    }

    @Step("Подписать и отправить документ")
    public SingAndSendDocumentPage singAndSendDocument() {
        sendBtn.shouldBe(visible).click();
        return new SingAndSendDocumentPage();
    }
}