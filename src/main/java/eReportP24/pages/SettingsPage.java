package eReportP24.pages;

import com.codeborne.selenide.SelenideElement;
import eReportP24.entity.BusinessAddress;
import eReportP24.entity.FactAddress;
import eReportP24.entity.SettingsDataItem;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

@Log4j
public class SettingsPage {
    SelenideElement fiscalService = $(By.xpath("//input[@name='com_dpi']//../following-sibling::input"));
    SelenideElement dfsBody = $(By.name("dpi_ruk"));
    SelenideElement pensionFundCode = $(By.xpath("//input[@name='pfu_kod']//../following-sibling::input"));
    SelenideElement registrationNumberPension = $(By.name("pfu_num"));
    SelenideElement koatuu = $(By.name("koatuu"));
    SelenideElement legalForm = $(By.xpath("//input[@name='com_foi']//../following-sibling::input"));
    SelenideElement legalFormTriggerWrap = $(By.id("com_foi-triggerWrap"));
    SelenideElement businessTriggerWrap = $(By.id("address_jur_id-triggerWrap"));
    SelenideElement businessTriggerWrapFlat = $(By.id("address_jur_flat_type-triggerWrap"));
    SelenideElement businessAddress = $(By.xpath("//input[@name='address_jur_id']//../following-sibling::input"));
    SelenideElement factAddressWrap = $(By.id("address_fact_id-triggerWrap"));
    SelenideElement factAddress = $(By.xpath("//input[@name='address_fact_id']//../following-sibling::input"));
    SelenideElement vatPayer = $(By.xpath("//input[@name='nds']//../following-sibling::input"));
    SelenideElement inn = $(By.xpath("//div[@id='nds_ipn']//input"));
    SelenideElement telephone = $(By.xpath("//input[@name='phone']//../following-sibling::input"));
    SelenideElement email = $(By.xpath("//input[@name='email']//../following-sibling::input"));
    SelenideElement director = $(By.xpath("//input[@name='boss']//../following-sibling::input"));
    SelenideElement accountant = $(By.xpath("//input[@name='buh']//../following-sibling::input"));
    SelenideElement mainNACE = $(By.xpath("//input[@name='com_kved']//../following-sibling::input"));
    SelenideElement saveBtn = $(By.id("btn_save"));
    SelenideElement closeBtn = $(By.xpath("//div[@id='btn_save']//following-sibling::div"));

    public SettingsPage() {
        switchTo().frame($(By.id("ifr")));
    }

    @Step("Редактируем все данные в настройках")
    public void editAllSettings(SettingsDataItem data) {
        fiscalService.setValue(data.getFiscalService());
        dfsBody.setValue(data.getDfsBody());
        pensionFundCode.setValue(data.getPensionFundCode());
        registrationNumberPension.setValue(data.getRegistrationNumberPension());
        koatuu.setValue(data.getKoatuu());
        setDataToLegalForm(data.getLegalForm());
        setDataToBusinessAddress(data.getBusinessAddress());
        setDataToFactAddress(data.getFactAddress());
        setDataToVatPayer(data.getVatPayer(), data.getInn());
        setDataToTelephone(data.getTelephone());
        setDataToDirector(data.getDirector());
        setDataToAccountant(data.getAccountant());
        email.setValue(data.getEmail());
        mainNACE.setValue(data.getMainNACE());
    }

    @Step("Проверяем все данные в настройках")
    public void checkAllSettingsValues(SettingsDataItem data) {
        fiscalService.shouldHave(value(data.getFiscalService()));
        dfsBody.shouldHave(value(data.getDfsBody()));
        pensionFundCode.shouldHave(value(data.getPensionFundCode()));
        registrationNumberPension.shouldHave(value(data.getRegistrationNumberPension()));
        koatuu.shouldHave(value(data.getKoatuu()));
        legalForm.shouldHave(value(data.getLegalForm()));
        businessAddress.shouldHave(value(data.getBusinessAddress().getAddress()));
        factAddress.shouldHave(value(data.getFactAddress().getAddress()));
        vatPayer.shouldHave(value(data.getVatPayer()));
        telephone.shouldHave(value(data.getTelephone()));
        director.shouldHave(value(data.getDirector()));
        accountant.shouldHave(value(data.getAccountant()));
        email.shouldHave(value(data.getEmail()));
        mainNACE.shouldHave(value(data.getMainNACE()));
    }

    @Step("Сохранить настройки")
    public void saveSettings() {
        switchTo().defaultContent();
        saveBtn.shouldBe(visible).click();
        switchTo().frame($(By.id("ifr")));
        $(By.xpath("//*[text()='Дані збережені']")).waitUntil(visible, 10 * 1000);
        $(By.xpath("//*[text()='Дані збережені']")).waitUntil(hidden, 10 * 1000);
    }

    @Step("Закрыть страничку \"Настройки\"")
    public void closeSettingsPage() {
        switchTo().defaultContent();
        closeBtn.shouldBe(visible).click();
    }

    @Step("Ввести {value} в поле \"Організаційно-правова форма (ОПФ)\"")
    public void setDataToLegalForm(String value) {
        legalFormTriggerWrap.shouldBe(visible).click();
        legalFormTriggerWrap.shouldBe(visible).click(); // костыль Костик-костолом
        $(By.xpath(String.format("//li[contains(text(), '%s')]", value))).waitUntil(visible, 5 * 1000).click();
    }

    @Step("Ввести данные в поле \"Юридична адреса підприємства\"")
    public void setDataToBusinessAddress(BusinessAddress businessAddress) {
        businessTriggerWrap.shouldBe(visible).click();
        $(By.xpath(String.format("//li[contains(text(), '%s')]", businessAddress.getAddress()))).waitUntil(visible, 5 * 1000).click();
    }

    @Step("Ввести данные в поле \"Фактична адреса підприємства\"")
    public void setDataToFactAddress(FactAddress factAddressValue) {
        factAddressWrap.shouldBe(visible).click();
        $(By.xpath(String.format("(//li[contains(text(), '%s')])[last()]", factAddressValue.getAddress()))).waitUntil(visible, 5 * 1000).click();
    }

    @Step("Ввести данные в поле \"Платник ПДВ\"")
    public void setDataToVatPayer(String vatPayerValue, String innValue) {
        vatPayer.shouldBe(visible).click();
        $(By.xpath(String.format("//li[contains(text(), '%s')]", vatPayerValue))).waitUntil(visible, 5 * 1000).click();
        if (vatPayerValue.equalsIgnoreCase("З ПДВ")) {
            inn.shouldBe(visible).setValue(innValue);
        }
    }

    @Step("Ввести данные в поле \"Телефон\"")
    public void setDataToTelephone(String telephoneValue) {
        telephone.shouldBe(visible).click();
        $(By.xpath(String.format("//li[contains(text(), '%s')]", telephoneValue))).waitUntil(visible, 5 * 1000).click();
    }

    @Step("Ввести данные в поле \"Директор\"")
    public void setDataToDirector(String directorValue) {
        director.shouldBe(visible).click();
        $(By.xpath(String.format("//li[contains(text(), '%s')]", directorValue))).waitUntil(visible, 5 * 1000).click();
    }

    @Step("Ввести данные в поле \"Бухгалтер\"")
    public void setDataToAccountant(String accountantValue) {
        accountant.shouldBe(visible).click();
        $(By.xpath(String.format("(//li[contains(text(), '%s')])[last()]", accountantValue))).waitUntil(visible, 5 * 1000).click();
    }
}
