package eReportP24;

import eReportP24.pages.MainPage;
import eReportP24.pages.SettingsPage;
import eReportP24.pages.instructions.*;
import eReportP24.utils.ConfigurationVariables;
import eReportP24.utils.listeners.AllureOnFailListener;
import io.qameta.allure.Epic;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static eReportP24.utils.Utils.getNewSettingsDataItem;

@Log4j
@Epic("")
@Listeners({AllureOnFailListener.class})
public class TestRunner extends SetUpAndTearDown {

    private final ConfigurationVariables CV = ConfigurationVariables.getInstance();
    private MainPage mainPage;
    private ElectronicReportingService electronicReportingService;
    private JoiningContract joiningContract;
    private ApplicationForRegistrationPage applicationForRegistrationPage;
    private SigningAndSending signingAndSending;
    private VATInvoice vatInvoice;
    private ReportAnnex4 reportAnnex4;
    private SettingsPage settingsPage;

    @Test(description = "Проеврим открытие станицы \"Сервіс «Електронна звітність»\"")
    public void checkElectronicReportingServicePage() {
        electronicReportingService = new MainPage().goToElectronicReportingService();
        electronicReportingService.checkElectronicReportServicePage();
    }

    @Test(description = "Проеврим открытие станицы \"Заява про приєднання до договору про визнання електронних документів\"")
    public void checkJoiningContractPage() {
        joiningContract = new MainPage().goToJoiningContract();
        joiningContract.checkJoiningContractPage();
    }

    @Test(description = "Проеврим открытие станицы \"Заявка на реєстрацію електронних цифрових підписів у системі електронної звітності органів державної статистики\"")
    public void checkApplicationForRegistrationPage() {
        applicationForRegistrationPage = new MainPage().goToApplicationForRegistrationPage();
        applicationForRegistrationPage.checkApplicationForRegistrationPage();
    }

    @Test(description = "Проеврим открытие станицы \"Інструкція підписання та надсилання електронної звітності за допомогою Crypto-Plugin\"")
    public void checkSigningAndSendingPagePage() {
        signingAndSending = new MainPage().goToSigningAndSendingPage();
        signingAndSending.checkSigningAndSendingPage();
    }

    @Test(description = "Проеврим открытие станицы \"Як отримати ПДВ-рахунок\"")
    public void checkVATInvoicePage() {
        vatInvoice = new MainPage().goToVATInvoicePage();
        vatInvoice.checkVATInvoicePage();
    }

    @Test(description = "Проеврим открытие станицы \"Інструкція звіту ЄСВ Додаток 4\"")
    public void checkReportAnnex4Page() {
        reportAnnex4 = new MainPage().goReportAnnex4Page();
        reportAnnex4.checkReportAnnex4Page();
    }

    @Test(description = "Редактирование настроек")
    public void editSettings() {
        settingsPage = new MainPage().openSettings();
        settingsPage.editAllSettings(getNewSettingsDataItem());
    }
}