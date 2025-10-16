#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${artifactIdWithoutDash};

import org.junit.jupiter.api.Test;
import ru.origami.kafka.models.KafkaRecord;
import ru.origami.testit_allure.allure.java_commons.Feature;
import ru.origami.testit_allure.annotations.Description;
import ru.origami.testit_allure.annotations.DisplayName;
import ru.origami.testit_allure.annotations.Link;
import ru.origami.testit_allure.annotations.Story;
import ru.example.steps.kafka.KafkaConsumerSteps;
import ru.example.steps.kafka.KafkaProducerSteps;

import java.util.List;

import static ru.example.models.kafka.ETopic.EXAMPLE_TOPIC;

@Feature("Пример")
@Story("Пример Kafka")
@DisplayName("Работа с Kafka")
@Link(name = "Документация работы с Kafka",
        url = "https://example.ru/confluence/pages/viewpage.action?pageId=123")
public class KafkaExample {

    KafkaProducerSteps producerSteps = new KafkaProducerSteps();

    KafkaConsumerSteps consumerSteps = new KafkaConsumerSteps();

    @Test
    @DisplayName("Пример работы с Producer")
    @Description("Пример отправки сообщения")
    void successProducer() {
        producerSteps.sendMessage(EXAMPLE_TOPIC, "key", "message");
        producerSteps.sendMessageAsJson(EXAMPLE_TOPIC, new Object());
        producerSteps.setPartition(1) // устанавливаем определенную партицию для отправки
                .sendMessage(EXAMPLE_TOPIC, "message");
    }

    @Test
    @DisplayName("Пример работы с Consumer")
    @Description("Пример вычитки топика на всю глубину")
    void successConsumer() {
        // вычитываем все сообщения из топика
        consumerSteps.readAllByKey(EXAMPLE_TOPIC, null);

        // вычитываем первое сообщение с конца, которое будет содержать "123", и мапим его из json в объект переданного класса
        // вычитка производится из указанных партиций
        consumerSteps.setPartitions(0, 1).readFirstByKeyFromJson(EXAMPLE_TOPIC, "123", Object.class);

        // вычитываем первое сообщение с конца за последние 5 секунд. Если ничего не будет найдено, вернется null без ошибки
        consumerSteps.setPeriod(5000L).readFirstByKeyFromJsonWithEmptyResult(EXAMPLE_TOPIC, null, Object.class);

        // вычитываем все сообщения из compact топика
        consumerSteps.readAllCompactByKey(EXAMPLE_TOPIC, null);
    }

    @Test
    @DisplayName("Пример работы с Consumer с подпиской на топик")
    @Description("Пример подписки на топик")
    void successConsumerSubscribe() {
        // подписываемся на топик
        consumerSteps.subscribe(EXAMPLE_TOPIC);

        // останавливаем подписку на топик и получаем результат
        List<KafkaRecord<String>> messages = consumerSteps.unsubscribeAndGetResults(EXAMPLE_TOPIC);

        consumerSteps.subscribe(EXAMPLE_TOPIC, Object.class);

        // останавливаем подписку на  топик и получаем результат
        // Если за время подписки не получено сообщений, содержащих нужную фразу, то в течении еще 2000мс слушаем топик и ждем сообщение
        // Если сообщение будет получено раньше, чем через указанные 2с, то отписка произойдет раньше
        messages = consumerSteps.unsubscribeWhenGetJsonMessage(EXAMPLE_TOPIC, "ключ поиска", 2000);
    }
}