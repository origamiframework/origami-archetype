#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.steps.ibm_mq;

import ru.origami.ibm_mq.IbmMqConsumer;
import ru.origami.common.environment.Environment;
import ru.origami.ibm_mq.models.Properties;

public class IbmMqCustomConsumer extends IbmMqConsumer {

    public IbmMqCustomConsumer() {
        properties = Properties.Builder()
                .setHost(Environment.get("ibm.mq.host"))
                .setPort(Integer.parseInt(Environment.get("ibm.mq.port")))
                .setQueueManagerName(Environment.get("ibm.mq.queue.manager"))
                .setChannel(Environment.get("ibm.mq.channel"))
                .setUsername(Environment.get("ibm.mq.username"))
                .setPassword(Environment.get("ibm.mq.password"))
                .build();
    }
}
