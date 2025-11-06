import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.components.CheckComponent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoqaHwPageObjectsFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckComponent checkComponent = new CheckComponent();
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.options().option("Male", "Female", "Other");
    String userNumber = faker.number().digits(10);
    String month = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    String year = String.format("%s", faker.number().numberBetween(1900, 2025));
    String day = String.format("%02d", faker.number().numberBetween(1, 28));
    String subjects = faker.options().option("Maths", "Hindi", "Biology", "Accounting", "Chemistry");
    String hobbies =  faker.options().option("Sports", "Reading", "Music");
    String pictureName = faker.options().option("picture.jpg");
    String currentAddress = faker.address().fullAddress();
    String state = faker.options().option("NCR", "Uttar Pradesh", "Rajasthan", "Haryana");
    String city = getCityFromState(state);

    public List<String> valueOfHobbies = new ArrayList<>(Arrays.asList("Sports", "Reading", "Music"));
    public List<String> valueOfSubject = new ArrayList<>(Arrays.asList("English", "Maths", "Chemistry", "Hindi", "Economics", "Biology"));
    public int numOfHobbies = faker.random().nextInt(1, (valueOfHobbies.size() - 1));
    public int numOfSubject = faker.random().nextInt(1, (valueOfSubject.size() - 1));

    String getCityFromState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            default -> "null";
        };
    }

    @Test
    void testAddition() {

        File pictureFile = new File("src/test/resources/" + pictureName);
        if (!pictureFile.exists()) {
            System.err.println("File not found: " + pictureFile.getAbsolutePath());
        }

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPicture(pictureName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setSubmit();

        checkComponent.checkResult("Student Name", firstName + " " + lastName);
        checkComponent.checkResult("Student Email", email);
        checkComponent.checkResult("Gender", gender);
        checkComponent.checkResult("Mobile", userNumber);
        checkComponent.checkResult("Date of Birth", String.format("%s %s,%s", day, month, year));
        checkComponent.checkResult("Subjects", subjects);
        checkComponent.checkResult("Hobbies", hobbies);
        checkComponent.checkResult("Picture", pictureName);
        checkComponent.checkResult("Address", currentAddress);
        checkComponent.checkResult("State and City", state + " " + city);
    }
}