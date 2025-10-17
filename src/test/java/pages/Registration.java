package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Registration {
   private SelenideElement
    firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    genderWrapper = $("#genderWrapper"),
    UserNumberInput = $("#userNumber"),
    calendarInput = $("#dateOfBirthInput"),
    subjectsInput = $("#Maths"),
    hobbiesWrapperInput =$("#hobbiesWrapper"),
    uploadPictureInput = $("#uploadPicture"),
    currentAddressInput =$("#currentAddress"),
    satefieldInput = $("#state"),
    stateInput = $("#react-select-3-input"),
    cityfieldInput = $("#city"),
    cityInput = $("#react-select-4-input"),
    submitInput =$("#submit");

    CalenderComponent calenderComponent = new CalenderComponent();
    }

    public Registration openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
       return this;
    }

    public Registration setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public Registration setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public Registration setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public Registration setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public Registration setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public Registration setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calenderComponent.setDate(day, month, year);

        return this;
    }
    public Registration setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;

    }
    public Registration setHobbies(String value) {
        hobbiesWrapperInput.$(byText(value).click());
    return this;
    }

    public Registration setPicture(String value) {
        uploadPictureInput.uploadPictureClasspath(value);
    return this;
    }

    public Registration setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
    return this;
   }
    public Registration setState(String value) {
        statefieldInput.click();
        stateInput.setValue(value).pressEnter();
    return this;
}
    public Registration setCity(String value) {
        cityfieldInput.click();
        cityInput.setValue(value).pressEnter();
    return this;
}
    public Registration setSubmit() {
        submitInput.click();
    return this;
}

    public Registration checkResult(String key, String value){
    $(".table-responsive").$(byText(key)).parent()
            .shouldHave(text(value));
    }
