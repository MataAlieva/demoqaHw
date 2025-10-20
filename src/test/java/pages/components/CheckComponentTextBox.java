package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckComponentTextBox {
    private SelenideElement checkResultInput = $("#output");
    public CheckComponentTextBox checkResultInput(String text) {
        checkResultInput.setValue(text);
        return this;
    }
}
