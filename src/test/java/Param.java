import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.beans.PropertyEditor;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class Param {


    @ParameterizedTest(name = "Поиск на Wildberries: {0}")
    @ValueSource(strings = {
            "шарф", "кроссовки", "рюкзак"
    })
    @DisplayName("Поиск на Wildberries")
    void search(String search) {
        open("https://www.wildberries.ru");
        $("#searchInput").setValue(search).pressEnter();
        $$(".product-card").shouldBe(sizeGreaterThan(0));
    }
    @ParameterizedTest(name = "Проверка заголовка страницы поиска {0}")
    @CsvSource({
            "шапка",
            "куртка",
            "футболка"
    })
    void searchTitleCheck(String query) {
        open("https://www.wildberries.ru/");
        $("#searchInput").setValue(query).pressEnter();
        $$(".product-card").shouldHave(CollectionCondition.sizeGreaterThan(0));
    }


    static Stream<String> popularQueries() {
        return Stream.of("носки", "джинсы", "перчатки");
    }

    @ParameterizedTest(name = "Проверка количества результатов для {0}")
    @MethodSource("popularQueries")
    void resultCountCheck(String query) {
        open("https://www.wildberries.ru/");
        $("#searchInput").setValue(query).pressEnter();
        $$(".product-card").shouldHave(CollectionCondition.sizeGreaterThan(20));
    }
}

