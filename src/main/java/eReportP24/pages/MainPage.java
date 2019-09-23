package eReportP24.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import eReportP24.pages.instructions.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement title = $(By.xpath("//*[text()='Електронна звітність']"));
    private SelenideElement instructions = $(By.className("instructions"));
    private SelenideElement settings = $(By.xpath("//div[@title='Налаштування']"));
    private SelenideElement tabInWork = $(By.className("tab-in-work check"));
    private SelenideElement tabAccepted = $(By.className("tab-accepted"));
    private SelenideElement createBtn = $(By.id("btn_create"));
    private SelenideElement importBtn = $(By.id("btn_import"));
    private SelenideElement sendBtn = $(By.id("btn_send"));
    private SelenideElement decryptBtn = $(By.id("btn_decrypt"));
    private SelenideElement deleteBtn = $(By.id("btn_delete"));

    @Step("Проверим, что мы на главной странице")
    public void checkMainPage() {
        title.shouldBe(visible);
    }

    @Step("Перейдем на страницу \"Сервіс «Електронна звітність»\"")
    public ElectronicReportingService goToElectronicReportingService() {
        instructions.shouldBe(visible).click();
        $(By.xpath("//a[text()='Сервіс «Електронна звітність»']")).waitUntil(visible, 5 * 1000).click();
        return new ElectronicReportingService();
    }

    @Step("Перейдем на страницу \"Заява про приєднання до договору про визнання електронних документів\"")
    public JoiningContract goToJoiningContract() {
        instructions.shouldBe(visible).click();
        $(By.xpath("//a[text()='Укладання «Заяви про приєднання до договору про визнання електронних документів»']")).waitUntil(visible, 5 * 1000).click();
        return new JoiningContract();
    }

    @Step("Перейдем на страницу \"Заявка на реєстрацію електронних цифрових підписів у системі електронної звітності органів державної статистики.\"")
    public ApplicationForRegistrationPage goToApplicationForRegistrationPage() {
        instructions.shouldBe(visible).click();
        $(By.xpath("//a[text()='Створення заявки на реєстрацію ЕЦП в органах статистики']")).waitUntil(visible, 5 * 1000).click();
        return new ApplicationForRegistrationPage();
    }

    @Step("Перейдем на страницу \"Інструкція підписання та надсилання електронної звітності за допомогою Crypto-Plugin\"")
    public SigningAndSending goToSigningAndSendingPage() {
        instructions.shouldBe(visible).click();
        $(By.xpath("//a[text()='Підписання та відправка документів в електронному вигляді']")).waitUntil(visible, 5 * 1000).click();
        return new SigningAndSending();
    }

    @Step("Перейдем на страницу \"Як отримати ПДВ-рахунок\"")
    public VATInvoice goToVATInvoicePage() {
        instructions.shouldBe(visible).click();
        $(By.xpath("//a[text()='Як отримати ПДВ-рахунок']")).waitUntil(visible, 5 * 1000).click();
        return new VATInvoice();
    }

    @Step("Перейдем на страницу \"Інструкція звіту ЄСВ Додаток 4\"")
    public ReportAnnex4 goReportAnnex4Page() {
        instructions.shouldBe(visible).click();
        $(By.xpath("//a[text()='Інструкція звіту ЄСВ Додаток 4']")).waitUntil(visible, 5 * 1000).click();
        return new ReportAnnex4();
    }

    @Step("Откроем \"Настройки\"")
    public SettingsPage openSettings() {
        settings.shouldBe(visible).click();
        $(By.id("ifr")).waitUntil(visible, 15 * 1000);
        return new SettingsPage();
    }

    @Step("Перейдем в \"Создание документа\"")
    public CreateDocument goToCreateDocument() {
        createBtn.shouldBe(Condition.visible).click();
        return new CreateDocument();
    }
}
