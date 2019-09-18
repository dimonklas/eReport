package eReportP24.utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WorkingWithBrowserTabs {

    @Step("Закрыть вкладку {nameTittle}: и переключиться на основную")
    public static void closeBrowserTab(String nameTittle) {
        sleep(500);
        if (WebDriverRunner.getWebDriver().getWindowHandles().size() > 1) {
            switchTo().window(nameTittle).close();
            switchTo().window(0);
        } else System.out.println("Вкладка не открылась");
    }

    @Step("Закрыть вкладку {number}: и переключиться на основную")
    public static void closeBrowserTab(int number) {
        sleep(500);
        if (WebDriverRunner.getWebDriver().getWindowHandles().size() > 1) {
            switchTo().window(number).close();
            switchTo().window(0);
        } else System.out.println("Вкладка не открылась");
    }

    public static void waitUntilBrowserTabsLoad(int number) {
        Wait().until(el -> getWebDriver().getWindowHandles().size() == number);
        sleep(1500);
    }
}
