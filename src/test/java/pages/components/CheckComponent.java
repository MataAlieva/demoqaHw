package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckComponent {
    private final SelenideElement checkResultInput = $("div.table-responsive");
    private final SelenideElement checkInput = $("#example-modal-sizes-title-lg");

    public CheckComponent checkResult(String value) {
        checkResultInput.shouldHave(text(value));
        return this;
    }
    public CheckComponent haveResult(String value) {
        checkResultInput.shouldHave(visible);
        return this;
    }
    public CheckComponent notHaveResult() {
        checkResultInput.shouldNotHave(visible);
        return this;
    }
}
