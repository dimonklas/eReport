package eReportP24;

import eReportP24.entity.j3001001.J3001001DataItem;
import eReportP24.pages.*;
import eReportP24.pages.instructions.*;
import eReportP24.utils.ConfigurationVariables;
import eReportP24.utils.listeners.AllureOnFailListener;
import io.qameta.allure.Epic;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static eReportP24.utils.Utils.getJ3001001DataItem;

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
    private J3001001Page j3001001Page;

//    @Test(description = "Проверим открытие станицы \"Сервіс «Електронна звітність»\"")
//    public void checkElectronicReportingServicePage() {
//        electronicReportingService = new MainPage().goToElectronicReportingService();
//        electronicReportingService.checkElectronicReportServicePage();
//    }
//
//    @Test(description = "Проверим открытие станицы \"Заява про приєднання до договору про визнання електронних документів\"")
//    public void checkJoiningContractPage() {
//        joiningContract = new MainPage().goToJoiningContract();
//        joiningContract.checkJoiningContractPage();
//    }
//
//    @Test(description = "Проверим открытие станицы \"Заявка на реєстрацію електронних цифрових підписів у системі електронної звітності органів державної статистики\"")
//    public void checkApplicationForRegistrationPage() {
//        applicationForRegistrationPage = new MainPage().goToApplicationForRegistrationPage();
//        applicationForRegistrationPage.checkApplicationForRegistrationPage();
//    }
//
//    @Test(description = "Проверим открытие станицы \"Інструкція підписання та надсилання електронної звітності за допомогою Crypto-Plugin\"")
//    public void checkSigningAndSendingPagePage() {
//        signingAndSending = new MainPage().goToSigningAndSendingPage();
//        signingAndSending.checkSigningAndSendingPage();
//    }
//
//    @Test(description = "Проверим открытие станицы \"Як отримати ПДВ-рахунок\"")
//    public void checkVATInvoicePage() {
//        vatInvoice = new MainPage().goToVATInvoicePage();
//        vatInvoice.checkVATInvoicePage();
//    }
//
//    @Test(description = "Проверим открытие станицы \"Інструкція звіту ЄСВ Додаток 4\"")
//    public void checkReportAnnex4Page() {
//        reportAnnex4 = new MainPage().goReportAnnex4Page();
//        reportAnnex4.checkReportAnnex4Page();
//    }
//
//    @Test(description = "Редактирование настроек")
//    public void editSettings() {
//        SettingsDataItem settingsDataItem = getNewSettingsDataItem();
//        settingsPage = new MainPage().openSettings();
//        settingsPage.editAllSettings(settingsDataItem);
//        settingsPage.saveSettings();
//        settingsPage.checkAllSettingsValues(settingsDataItem);
//        settingsPage.closeSettingsPage();
//        new MainPage().openSettings();
//        settingsPage.checkAllSettingsValues(settingsDataItem);
//    }

    @Test(description = "Создадим документ")
    public void createDocument() {
        j3001001Page = new J3001001Page();
        J3001001DataItem j3001001DataItem = getJ3001001DataItem();
        CreateDocument createDocument = new MainPage().goToCreateDocument();
        createDocument.searchAndOpenDocumentTemplate(j3001001DataItem.getDeclarationName());
        j3001001Page
                .editDocument(j3001001DataItem)
                .saveDocument()
                .checkDocument(j3001001DataItem);
        SingAndSendDocumentPage singAndSendDocumentPage = j3001001Page.singAndSendDocument();
        singAndSendDocumentPage.uploadKeys();
    }

    @Test(description = "Создадим документ")
    public void createDocument2() {
        j3001001Page = new J3001001Page();
        J3001001DataItem j3001001DataItem = getJ3001001DataItem();
        CreateDocument createDocument = new MainPage().goToCreateDocument();
        createDocument.searchAndOpenDocumentTemplate(j3001001DataItem.getDeclarationName());
        j3001001Page
                .editDocument(j3001001DataItem)
                .saveDocument()
                .checkDocument(j3001001DataItem);
        SingAndSendDocumentPage singAndSendDocumentPage = j3001001Page.singAndSendDocument();
        singAndSendDocumentPage.uploadKeys();
    }
}