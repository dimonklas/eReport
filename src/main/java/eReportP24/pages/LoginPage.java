package eReportP24.pages;

import com.codeborne.selenide.SelenideElement;
import eReportP24.utils.ConfigurationVariables;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static eReportP24.utils.WorkingWithBrowserTabs.closeBrowserTab;

public class LoginPage {

    private final ConfigurationVariables CV = ConfigurationVariables.getInstance();

    private SelenideElement password = $(By.id("password"));
    private SelenideElement comID = $(By.id("com_id"));
    private SelenideElement dropdown = $(By.className("dropdown"));

    @Step("Откроем главную страницу")
    public LoginPage openLoginPage() {
        open(CV.urlBase);
        return this;
    }

    @Step("Войдём на сайт")
    public void login() {
        openLoginPage();
        password.shouldBe(visible, enabled);
        password.sendKeys(CV.enterPassword);
        password.pressEnter();
        $(By.xpath("//*[text()='Войти под компанией:']")).waitUntil(visible, 15 * 1000);
        selectCompany();
        selectVersionAndEnter();
    }

    @Step("Выберем компанию")
    public void selectCompany() {
        comID.shouldBe(visible).sendKeys(CV.comID);
        $(By.xpath(String.format("//*[text()='%s']", CV.comName))).shouldBe(visible).click();
        $(By.xpath("//li[text()='id_ecb => 1004410776']")).waitUntil(visible, 15 * 1000);
    }

    @Step("Выберем версию и зойдём на сайт")
    public void selectVersionAndEnter() {
        dropdown.shouldBe(visible).click();
        $(By.xpath("//*[text()=' На сайт, в.3 (UK)']")).waitUntil(visible, 5 * 1000).click();
        closeBrowserTab(0);
        $(By.id("doNotNotify-boxLabelEl")).waitUntil(visible, 5 * 1000).click();
        $(By.xpath("//*[text()='Закрити']")).waitUntil(visible, 5 * 1000).click();
        new MainPage().checkMainPage();
    }
}
