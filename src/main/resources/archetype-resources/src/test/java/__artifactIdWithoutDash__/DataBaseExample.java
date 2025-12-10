#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${artifactIdWithoutDash};

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.origami.testit_allure.allure.java_commons.Feature;
import ru.origami.testit_allure.annotations.Description;
import ru.origami.testit_allure.annotations.Link;
import ru.origami.testit_allure.annotations.Story;
import ru.example.steps.fixtures.ExampleFixtureSteps;

import static ru.origami.common.OrigamiHelper.getStringUUID;

@Feature("Пример")
@Story("Пример Hibernate")
@DisplayName("Работа с БД")
@Link(name = "Документация работы с БД",
        url = "https://example.ru/confluence/pages/viewpage.action?pageId=123")
public class DataBaseExample {

    ExampleFixtureSteps fixtureSteps = new ExampleFixtureSteps();

    @Test
    @DisplayName("Пример работы с БД")
    @Description("Пример запросов к БД")
    void successQuery() {
        fixtureSteps.getExamplesById(getStringUUID());

        fixtureSteps.updateStatusById(getStringUUID(), "Новая");

        fixtureSteps.deleteFromTableByName("example_table");
    }
}