package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;
import static org.openqa.selenium.By.cssSelector;

public class CheckComponent {
    private SelenideElement checkResultInput = $(cssSelector("div.table-responsive"));
    private SelenideElement checkInput = $(cssSelector("#example-modal-sizes-title-lg"));

    public void checkResult(String key, String value) {
        checkResultInput.shouldHave(text(key), text(value));
    }
}