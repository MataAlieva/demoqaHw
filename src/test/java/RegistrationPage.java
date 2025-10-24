import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement header = $("h1"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirth"),
            subjectsWrapper = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#stateCity-wrapper"),
            cityInput = $("#city"),
            submitInput = $("#submit");

    CalenderComponent calenderComponent = new CalenderComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration"));
        removeBanners();
        return this;
    }

    private  void removeBanners() {
           executeJavaScript("$('footer').remove();");
           executeJavaScript("$('#fixedban').remove();");
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calenderComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationPage setSubjects(String value) {
        subjectsWrapper.setValue(value).pressEnter();
        return this;

    }
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture(String value) {
        uploadPictureInput.uploadFromClasspath("picture.jpg/");
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState(String value) {
        stateInput.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity(String value) {
        cityInput.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setSubmit() {
        submitInput.click();
        return this;
    }
}


