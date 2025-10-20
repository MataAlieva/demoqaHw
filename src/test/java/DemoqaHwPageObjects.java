import com.codeborne.selenide.CheckResult;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Modal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaHwPageObjects extends tests.TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void testAddition() {
        registrationPage.openPage()
                .setFirstName("Mata")
                .setLastName("Alieva")
                .setEmail("Mata@gmail.com")
                .setGender("Female")
                .setUserNumber("89269999999")
                .setDateOfBirth("09", "Nov", "1993")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setPicture("picture.jpg")
                .setCurrentAddress("Moscow")
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit();

        registrationPage.checkResult("Student Name", "Mata Alieva")
                .checkResult("Student Email", "Mata@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "89269999999")
                .checkResult("DateOfBirth", "09 Nov 1993 ")
                .checkResult( "Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "picture.jpg")
                .checkResult("Address", "Moscow")
                .checkResult("State", "NCR")
                .checkResult("City", "Delhi");
    }

    @Test
    void testAdditionMinimal() {
        registrationPage.openPage()
                .setFirstName("Mata")
                .setLastName("Alieva")
                .setEmail("Mata@gmail.com")
                .setGender("Female")
                .setUserNumber("89269999999")
                .setSubmit();

        registrationPage.checkResult("Student Name", "Mata Alieva")
                .checkResult("Student Email", "Mata@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "89269999999");
    }

    @Test
    void testAdditionNegative() {
        registrationPage.openPage()
                .setSubmit();

    }
}