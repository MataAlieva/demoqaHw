import org.junit.jupiter.api.Test;

public class TextBoxTest extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();
    ChekComponentForTextBox chekComponentForTextBox = new CheckCompanentForTextBox();
    @Test
    void textBoxTest(){
        textBoxPage.open()
                .setFirstName("Mata")
                .setLastName("Alieva")
                .setUserEmail("Mata@gmail.com")
                .setGender("Female")
                .setUserNumber("89269999999")
                .setSubmit()
                .checkResult("Student Name", "Mata Alieva")
                .checkResult("Student Email", "Mata@gmail.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "89269999999");

    }
}
