package eReportP24.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CreateDocument {
    private SelenideElement fiscalService = $(By.xpath("//span[text()='Фіскальна служба']"));
    private SelenideElement searchField = $(By.xpath("//div[@id='search']//input"));
    private SelenideElement firstRow = $(By.xpath("(//div[@id='tab_0']//tbody//tr)[2]"));
    private SelenideElement createBtn = $(By.xpath("//*[text()='Створити']/.."));


    @Step("Ща найдём шаблон документа по значению \"{searchValue}\"")
    public void searchAndOpenDocumentTemplate(String searchValue) {
        searchField.shouldBe(visible).setValue(searchValue);
        firstRow.shouldBe(visible).click();
        createBtn.click();
    }
}
