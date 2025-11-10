import data.TestData;
import org.junit.jupiter.api.Test;
import pages.components.CheckComponent;

import java.io.File;

public class DemoqaHwPageObjectsFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckComponent checkComponent = new CheckComponent();
    TestData testData = new TestData();

    @Test
    void testAddition() {

        File pictureFile = new File("src/test/resources/" + testData.pictureName);
        if (!pictureFile.exists()) {
            System.err.println("File not found: " + pictureFile.getAbsolutePath());
        }

        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .setPicture(testData.pictureName)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .setSubmit();

        checkComponent.checkResult("Student Name", testData.firstName + " " + testData.lastName);
        checkComponent.checkResult("Student Email", testData.email);
        checkComponent.checkResult("Gender", testData.gender);
        checkComponent.checkResult("Mobile", testData.userNumber);
        checkComponent.checkResult("Date of Birth", String.format("%s %s,%s", testData.day, testData.month, testData.year));
        checkComponent.checkResult("Subjects", testData.subjects);
        checkComponent.checkResult("Hobbies", testData.hobbies);
        checkComponent.checkResult("Picture", testData.pictureName);
        checkComponent.checkResult("Address", testData.currentAddress);
        checkComponent.checkResult("State and City", testData.state + " " + testData.city);
    }
}