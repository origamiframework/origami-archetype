#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.steps.kafka;

import ru.origami.common.environment.Environment;
import ru.origami.kafka.ConsumerSteps;
import ru.origami.kafka.models.ESaslMechanism;
import ru.origami.kafka.models.ESecurityProtocol;
import ru.origami.kafka.models.Properties;

public class KafkaConsumerSteps extends ConsumerSteps {

    public KafkaConsumerSteps() {
        properties = new Properties.Builder()
                .setBootstrapServers(Environment.get("kafka.bootstrap-servers"))
                .addSecurityProtocol(ESecurityProtocol.PLAINTEXT, "local.*")
                .addSecurityProtocol(ESecurityProtocol.SASL_SSL, "dev")
                .addSaslMechanism(ESaslMechanism.PLAIN, "dev")
                .setUsername(Environment.getWithNullValue("kafka.username"))
                .setPassword(Environment.getWithNullValue("kafka.password"))
                .setSslTruststoreLocation(Environment.getWithNullValue("kafka.ssl.truststore.location"))
                .setSslTruststorePassword(Environment.getWithNullValue("kafka.ssl.truststore.password"))
                .build();
    }
}
