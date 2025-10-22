package tests;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxTests extends tests.TestBase {
    pages.textBoxPage.TextBoxPage textBoxPage = new pages.textBoxPage.TextBoxPage();

    @Test
    void textBoxTest() {
        textBoxPage.open("/text-box")
                .setUserName("Mata")
                .setUserEmail("Mata@gmail.com")
                .setUserCurrentAddress("Moscow")
                .setUserPermanentAddress("FFFFF")
                .setSubmit()
                .checkResult("Name", "Mata")
                .checkResult("Email", "Mata@gmail.com")
                .checkResult("CurrentAddress", "Moscow")
                .checkResult("PermanentAddress", "FFFFF");

    }
}
