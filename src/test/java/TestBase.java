package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverLogs;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 10000;

    }
}
