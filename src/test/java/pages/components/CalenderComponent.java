package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalenderComponent {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--009:not(.react-datepicker__day--outside-month)").click();

    }

}
