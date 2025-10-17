package tests;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Modal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.Registration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaHwPageObjects extends TestBase {

    Registration registration = new Registration();

    @Test
    void testAddition() {
        registration.openPage()
                .setFirstName("Mata")
                .setLastName("Alieva")
                .setUserEmail("Mata@gmail.com")
                .setGender("Female")
                .setUserNumber("89269999999")
                .setDateOfBirth("09", "Nov", "1993")
                .setSubjects("Maths")
                .setHobbies("Sports", "Reading")
                .setPicture("picture.jpg")
                .setCurrentAddress("Moscow")
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit();

        registration.checkResult("Student Name", "Mata Alieva")
                .checkResult("Student Email", "Mata@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "89269999999")
                .checkResult("DateOfBirth", "09 Nov 1993 ")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports", "Reading")
                .checkResult("Picture", "picture.jpg")
                .checkResult("Address", "Moscow")
                .checkResult("State", "NCR")
                .checkResult("City", "Delhi")
                .close();
    }

    @Test
    void testAdditionMinimal() {
        registration.openPage()
                .setFirstName("Mata")
                .setLastName("Alieva")
                .setUserEmail("Mata@gmail.com")
                .setGender("Female")
                .setUserNumber("89269999999")
                .setSubmit();

        registration.checkResult("Student Name", "Mata Alieva")
                .checkResult("Student Email", "Mata@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "89269999999")
                .close();
    }

    @Test
    void testAdditionNegative() {
        registration.openPage()
                .setSubmit();
        registration.checkResult();
    }
}