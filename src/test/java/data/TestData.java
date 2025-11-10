package data;

import com.github.javafaker.Faker;

public class TestData {
    private final Faker faker = new Faker();

    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String email = faker.internet().emailAddress();
    public final String gender = faker.options().option("Male", "Female", "Other");
    public final String userNumber = faker.number().digits(10);
    public final String month = faker.options().option("January", "February", "March", "April",
            "May", "June", "July", "August", "September", "October", "November", "December");
    public final String year = String.format("%s", faker.number().numberBetween(1900, 2025));
    public final String day = String.format("%02d", faker.number().numberBetween(1, 28));
    public final String subjects = faker.options().option("Maths", "Hindi", "Biology", "Accounting", "Chemistry");
    public final String hobbies = faker.options().option("Sports", "Reading", "Music");
    public final String pictureName = "picture.jpg"; // Название файла, оно константно
    public final String currentAddress = faker.address().fullAddress();
    public final String state = faker.options().option("NCR", "Uttar Pradesh", "Rajasthan", "Haryana");
    public final String city;

    public TestData() {
        this.city = getCityFromState(this.state);
    }

    private String getCityFromState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            default -> "null";
        };
    }
}