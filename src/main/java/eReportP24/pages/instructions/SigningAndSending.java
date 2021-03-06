package eReportP24.pages.instructions;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static eReportP24.utils.WorkingWithBrowserTabs.closeBrowserTab;
import static eReportP24.utils.WorkingWithBrowserTabs.waitUntilBrowserTabsLoad;

public class SigningAndSending {
    private String titleText = "Інструкція підписання та надсилання електронної звітності за допомогою Crypto-Plugin";

    public void checkSigningAndSendingPage() {
        waitUntilBrowserTabsLoad(2);
        switchTo().window(titleText);
        $(By.xpath(String.format("//div[contains(text(),'%s')]", titleText))).waitUntil(visible, 5 * 1000);
        closeBrowserTab(titleText);
    }
}
