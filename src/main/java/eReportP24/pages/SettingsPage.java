package eReportP24.pages;

import com.codeborne.selenide.SelenideElement;
import eReportP24.entity.BusinessAddress;
import eReportP24.entity.FactAddress;
import eReportP24.entity.SettingsDataItem;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
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
    SelenideElement telephone = $(By.xpath("//input[@name='phone']//../following-sibling::input"));
    SelenideElement email = $(By.xpath("//input[@name='email']//../following-sibling::input"));
    SelenideElement director = $(By.xpath("//input[@name='boss']//../following-sibling::input"));
    SelenideElement accountant = $(By.xpath("//input[@name='buh']//../following-sibling::input"));
    SelenideElement mainNACE = $(By.xpath("//input[@name='com_kved']//../following-sibling::input"));

    public SettingsPage() {
        switchTo().frame($(By.id("ifr")));
    }

    public void editAllSettings(SettingsDataItem data) {
        fiscalService.setValue(data.getFiscalService());
        dfsBody.setValue(data.getDfsBody());
        log.info(data.getPensionFundCode());
        pensionFundCode.setValue(data.getPensionFundCode());
        registrationNumberPension.setValue(data.getRegistrationNumberPension());
        koatuu.setValue(data.getKoatuu());

        setDataToLegalForm(data.getLegalForm());
//        setDataToBusinessAddress(data.getBusinessAddress());
        setDataToFactAddress(data.getFactAddress());

        vatPayer.setValue(data.getVatPayer());
        telephone.setValue(data.getTelephone());
        email.setValue(data.getEmail());
        director.setValue(data.getDirector());
        accountant.setValue(data.getAccountant());
        mainNACE.setValue(data.getMainNACE());
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
        $(By.xpath(String.format("//li[contains(text(), '%s')]", factAddressValue.getAddress()))).waitUntil(visible, 5 * 1000).click();
    }
}
