#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${artifactIdWithoutDash};

import org.junit.jupiter.api.Test;
import ru.origami.testit_allure.allure.java_commons.Feature;
import ru.origami.testit_allure.annotations.Description;
import ru.origami.testit_allure.annotations.DisplayName;
import ru.origami.testit_allure.annotations.Link;
import ru.origami.testit_allure.annotations.Story;
import ru.example.steps.ibm_mq.IbmMqCustomBrowser;
import ru.example.steps.ibm_mq.IbmMqCustomConsumer;
import ru.example.steps.ibm_mq.IbmMqCustomProducer;

import javax.jms.Message;
import java.util.List;

import static ru.example.models.ibm_mq.EQueue.EXAMPLE_QUEUE;

@Feature("Пример")
@Story("Пример IBM MQ")
@DisplayName("Работа с IBM MQ")
@Link(name = "Документация работы с IBM MQ",
        url = "https://example.ru/confluence/pages/viewpage.action?pageId=123")
public class IbmMqExample {

    IbmMqCustomProducer producer = new IbmMqCustomProducer();

    IbmMqCustomBrowser browser = new IbmMqCustomBrowser();

    IbmMqCustomConsumer consumer = new IbmMqCustomConsumer();

    @Test
    @DisplayName("Пример работы с Producer")
    @Description("Пример отправки сообщения")
    void successProducer() {
        producer.send(EXAMPLE_QUEUE, "message");
    }

    @Test
    @DisplayName("Пример работы с Consumer")
    @Description("Пример вычитки")
    void successConsumer() {
        Message message = consumer.read(EXAMPLE_QUEUE); // после прочтения, вычитанное сообщение более недоступно другим подписчикам
    }

    @Test
    @DisplayName("Пример работы с Browser")
    @Description("Пример вычитки")
    void successBrowser() {
        List<Message> messages = browser.read(EXAMPLE_QUEUE); // после прочтения, вычитанные сообщения остаются доступны другим подписчикам
    }
}