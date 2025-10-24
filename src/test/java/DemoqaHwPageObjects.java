import org.junit.jupiter.api.Test;
import pages.components.CheckComponent;

public class DemoqaHwPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckComponent checkComponent = new CheckComponent();

    @Test
    void testAddition() {
        registrationPage.openPage()
                .setFirstName("Mata")
                .setLastName("Alieva")
                .setEmail("Mata@gmail.com")
                .setGender("Female")
                .setUserNumber("8926999999")
                .setDateOfBirth("09", "November", "1993")
                .setSubjects("Maths")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setPicture("picture.jpg")
                .setCurrentAddress("Moscow")
                .setState("NCR")
                .setCity("Delhi")
                .setSubmit();

        checkComponent.checkResult("Student Name", "Mata Alieva");
        checkComponent.checkResult("Student Email", "Mata@gmail.com");
        checkComponent.checkResult("Gender", "Female");
        checkComponent.checkResult("Mobile", "8926999999");
        checkComponent.checkResult("Date of Birth", "09 November,1993 ");
        checkComponent.checkResult("Subjects", "Maths");
        checkComponent.checkResult("Hobbies", "Sports, Reading");
        checkComponent.checkResult("Picture", "picture.jpg");
        checkComponent.checkResult("Address", "Moscow");
        checkComponent.checkResult("State and City", "NCR Delhi");
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

        checkComponent.checkResult("Student Name", "Mata Alieva");
        checkComponent.checkResult("Student Email", "Mata@gmail.com");
        checkComponent.checkResult("Gender", "Female");
        checkComponent.checkResult("Mobile","8926999999");
    }

    @Test
    void testAdditionNegative() {
        registrationPage.openPage()
                .setSubmit();

    }
}