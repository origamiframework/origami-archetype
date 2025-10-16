#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.steps.${artifactIdWithoutDash};

import io.restassured.response.Response;
import ru.origami.testit_allure.annotations.Step;

public class ExampleApiSteps extends CommonExampleRequestsSteps {

    @Step("Отправляем запрос GET /api/v1/example")
    public Response getExample(String token) {
        return getExampleRequestSpec(token).get();
    }
}