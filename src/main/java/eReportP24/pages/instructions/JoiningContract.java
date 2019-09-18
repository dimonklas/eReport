package eReportP24.pages.instructions;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static eReportP24.utils.WorkingWithBrowserTabs.closeBrowserTab;
import static eReportP24.utils.WorkingWithBrowserTabs.waitUntilBrowserTabsLoad;

public class JoiningContract {

    private String titleText = "F/J1392001 «Заява про приєднання до договору про визнання електронних документів»";

    public void checkJoiningContractPage() {
        waitUntilBrowserTabsLoad(2);
        switchTo().window(titleText);
        $(By.xpath(String.format("//div[contains(text(),'%s')]", titleText))).waitUntil(visible, 5 * 1000);
        closeBrowserTab(titleText);
    }
}
