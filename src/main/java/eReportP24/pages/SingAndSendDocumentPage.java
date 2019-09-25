package eReportP24.pages;

import com.codeborne.selenide.SelenideElement;
import eReportP24.utils.ConfigurationVariables;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SingAndSendDocumentPage {
    private final ConfigurationVariables CV = ConfigurationVariables.getInstance();

    private SelenideElement iframeSendReport = $(By.xpath("//div[@id='sign_container']/iframe"));
    private SelenideElement pbKeysSelect = $(By.xpath("//span[text()='Ключі ПриватБанку']"));
    private SelenideElement keyPathInput = $(By.xpath("//div[@data-type='jks1']//input[@placeholder]"));
    private SelenideElement passwordKeyInput = $(By.xpath("//div[@data-type='jks1' and @class='wrap-label']//input[@type='password']"));
    private SelenideElement nextButton = $(By.xpath("//div[@class='btn btn-green btn-primary']"));
    private SelenideElement signAndSendButton = $(By.id("sign_and_send"));
    private SelenideElement roleSelect = $(By.xpath("//table[@class='keys-table']//select"));
    private SelenideElement keysSave = $(By.id("keys-save"));
    private SelenideElement keysCancel = $(By.id("keys-cancel"));
    private SelenideElement reportStage = $(By.id("report_stage"));
    private SelenideElement reloadKeys = $(By.xpath("//span[text()='Перевантажити ключі']"));


    public SingAndSendDocumentPage() {
        switchTo().frame(iframeSendReport);
    }

    @Step("Загружаем ключи (ЕЦП)")
    public void uploadKeys() {
        sleep(1500);
        if (reloadKeys.getAttribute("class").contains("disabled")) {
            pbKeysSelect.shouldBe(visible).click();
            keyPathInput.shouldBe(visible).sendKeys(new File("src/main/resources/supportFiles/pb_3324314930.jks").getAbsolutePath());
            nextButton.shouldBe(visible).click();
            passwordKeyInput.shouldBe(visible).sendKeys(CV.pbKeyPassword);
            signAndSendButton.shouldBe(visible).click();
            roleSelect.shouldBe(visible).selectOption("Директор");
            keysSave.shouldBe(visible).click();
            $x("//div[contains(text(), 'Оброблено документів')]").waitUntil(hidden, 60 * 1000);
            $x("//*[text()='Документ успішно підписаний і надісланий']").waitUntil(visible, 5 * 1000);
            $(By.id("button-1050-btnEl")).shouldBe(visible, enabled).click();
        } else {
            passwordKeyInput.shouldBe(visible).sendKeys(CV.pbKeyPassword);
            signAndSendButton.shouldBe(visible).click();
            $x("//div[contains(text(), 'Оброблено документів')]").waitUntil(hidden, 60 * 1000);
            $x("//*[text()='Документ успішно підписаний і надісланий']").waitUntil(visible, 5 * 1000);
            $(By.id("button-1050-btnEl")).shouldBe(visible, enabled).click();
        }
        switchTo().defaultContent();
    }
}
