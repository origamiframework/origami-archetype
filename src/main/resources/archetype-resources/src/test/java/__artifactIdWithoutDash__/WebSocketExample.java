#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${artifactIdWithoutDash};

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.example.models.ws.ExampleWsMessage;
import ru.origami.testit_allure.allure.java_commons.Feature;
import ru.origami.testit_allure.annotations.Description;
import ru.origami.testit_allure.annotations.Link;
import ru.origami.testit_allure.annotations.Story;
import ru.example.steps.websocket.ExampleWsSteps;

import java.util.List;

import static ru.example.models.ws.EWsTopic.EXAMPLE_TOPIC;

@Feature("Пример")
@Story("Пример WebSocket")
@DisplayName("Работа с WebSocket")
@Link(name = "Документация работы с WebSocket",
        url = "example.ru/confluence/pages/viewpage.action?pageId=123")
public class WebSocketExample {

    ExampleWsSteps wsSteps = new ExampleWsSteps();

    @Test
    @DisplayName("Пример работы с WebSocket")
    @Description("Пример подписки на Websocket топик")
    void successWebSocket() {
        wsSteps.subscribe(EXAMPLE_TOPIC);
        List<String> stringMessages = wsSteps.unsubscribeAndGetResults(EXAMPLE_TOPIC);

        wsSteps.subscribe(EXAMPLE_TOPIC, ExampleWsMessage.class);
        List<ExampleWsMessage> messages = wsSteps.unsubscribeAndGetResults(EXAMPLE_TOPIC);
    }
}