#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${artifactIdWithoutDash};

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import ru.origami.testit_allure.allure.java_commons.Feature;
import ru.origami.testit_allure.annotations.Description;
import ru.origami.testit_allure.annotations.DisplayName;
import ru.origami.testit_allure.annotations.Link;
import ru.origami.testit_allure.annotations.Story;
import ru.example.models.${artifactIdWithoutDash}.ExampleResponse;
import ru.example.models.${artifactIdWithoutDash}.response.BaseResponse;
import ru.example.steps.${artifactIdWithoutDash}.ExampleSteps;

import java.util.Collections;

@Feature("Пример")
@Story("Пример REST API")
@DisplayName("GET /api/v1/example. Получение списка")
@Link(name = "Документация метода GET /api/v1/example",
        url = "https://example.ru/confluence/pages/viewpage.action?pageId=123")
public class RestApiExample {

    ExampleSteps exampleSteps = new ExampleSteps();

    @Test
    @DisplayName("Вызов метода GET /api/v1/example. Позитивный сценарий")
    @Description("Проверяем, что вернулись корректные клиенты")
    void successGetExample() {
        String token = "token";

        Response response = exampleSteps.getExample(token);
        exampleSteps.responseShouldBeSuccess();
        exampleSteps.exampleListShouldBeEquals(Collections.emptyList(), BaseResponse.createResponseFrom(response, ExampleResponse.class));
    }
}