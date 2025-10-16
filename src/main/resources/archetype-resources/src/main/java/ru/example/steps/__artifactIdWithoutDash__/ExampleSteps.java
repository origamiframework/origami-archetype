#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.steps.${artifactIdWithoutDash};

import ru.origami.testit_allure.annotations.Step;
import ru.example.models.${artifactIdWithoutDash}.ExampleResponse;
import ru.example.models.${artifactIdWithoutDash}.response.BaseResponse;
import ru.example.models.kafka.ExampleTopicMessage;

import java.util.List;

import static ru.origami.common.asserts.Asserts.*;

public class ExampleSteps extends ExampleApiSteps {

    @Step("Проверяем полученные данные")
    public void exampleListShouldBeEquals(List<ExampleTopicMessage> expectedList, BaseResponse<ExampleResponse> resp) {
        assertAll(
                () -> assertNull("errors", resp.getErrors()),
                () -> assertNull("meta", resp.getMeta()),
                () -> assertListSize("data", expectedList.size(), resp.getData())
        );

        for (int i = 0; i < expectedList.size(); i++) {
            exampleShouldBeEquals(expectedList.get(i), resp.getData().get(i));
        }
    }

    @Step("Проверяем объект: {expected.id}")
    public void exampleShouldBeEquals(ExampleTopicMessage expected, ExampleResponse actual) {
        assertAll(
                () -> assertEquals("id", expected.getId(), actual.getId()),
                () -> assertEquals("name", expected.getName(), actual.getName())
        );
    }
}
