#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.steps.websocket;

import ru.origami.common.environment.Environment;
import ru.origami.websocket.WsProperties;
import ru.origami.websocket.WsSteps;

public class ExampleWsSteps extends WsSteps {

    public ExampleWsSteps() {
        properties = WsProperties.Builder()
                .setUrl(Environment.get("websocket.url"))
                .setPort(Environment.getWithNullValue("websocket.port"))
                .setEndpoint(Environment.get("websocket.endpoint"))
                .setWithWss(Boolean.parseBoolean(Environment.getWithNullValue("websocket.with.wss")))
                .build();
    }
}
