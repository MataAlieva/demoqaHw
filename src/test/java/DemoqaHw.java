import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaHw {
    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com&quot";
    }

    @Test
    void testAddition() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        $("#firstName").setValue("Mata");
        $("#lastName").setValue("Alieva");
        $("#userEmail").setValue("Mata@gmail.com");
        $(byText("Female")).click();
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

        $("output").$("#firstName").shouldHave(text("Mata"));
        $("output").$("#lasttName").shouldHave(text("Alieva"));
        $("output").$("#userEmail").shouldHave(text("Mata@gmail.com"));
        $("output").$("#Gender").shouldHave(text("Female"));
        $("output").$("#Mobile").shouldHave(text("89269999999"));
        $("output").$("#DataOfBirth").shouldHave(text("09 November, 1993"));
        $("output").$("#Subjects").shouldHave(text("Maths"));
        $("output").$("#Hobbies").shouldHave(text("Sports, Reading"));
        $("output").$("#Picture").shouldHave(text("picture.jpg"));
        $("output").$("#Address").shouldHave(text("Moscow"));
        $("output").$("#State and City").shouldHave(text("NCR Deihi"));
    }
}