import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DemoqaHwRemote extends TestBaseRemote {

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    @Tag("demoqa")
    void testAddition1() {
        step("Open form", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('footer').remove();");
            executeJavaScript("$('#fixedban').remove();");
        });
        step("Fill form", () -> {
            $("#firstName").setValue("Mata");
            $("#lastName").setValue("Alieva");
            $("#userEmail").setValue("Mata@gmail.com");
            //    $("#genterWrapper").$(byText("Female"));
            $(byText("Female")).click();
            $("#userNumber").setValue("8926999999");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("November");
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
        });
        step("Verify results", () -> {
         $(".modal-dialog").should(appear);
         $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
         $(".table-responsive").shouldHave(text("Mata"), text("Alieva"),
           text("Mata@gmail.com"), text("8926999999"));
         });
    }
}


    //    $("output").$("#firstName").shouldHave(text("Mata"));
    //    $("output").$("#lasttName").shouldHave(text("Alieva"));
    //    $("output").$("#userEmail").shouldHave(text("Mata@gmail.com"));
    //    $("output").$("#Gender").shouldHave(text("Female"));
    //    $("output").$("#Mobile").shouldHave(text("89269999999"));
    //    $("output").$("#DataOfBirth").shouldHave(text("09 November, 1993"));
    //    $("output").$("#Subjects").shouldHave(text("Maths"));
    //    $("output").$("#Hobbies").shouldHave(text("Sports, Reading"));
    //    $("output").$("#Picture").shouldHave(text("picture.jpg"));
    //    $("output").$("#Address").shouldHave(text("Moscow"));
    //    $("output").$("#State and City").shouldHave(text("NCR Deihi"));
