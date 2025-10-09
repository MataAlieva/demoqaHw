import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaHw {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @Test
    void TestAddition() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("document.querySelector('#fixedban')?.remove();");
        executeJavaScript("document.querySelector('footer')?.remove();");

        $("#firstName").setValue("Mata");
        $("#lastName").setValue("Alieva");
        $("#userEmail").setValue("mata@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("89269999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--009:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("picture.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").scrollTo().click();

    }
}