#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.models.ws;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.origami.websocket.models.WsTopic;

@Getter
@AllArgsConstructor
public enum EWsTopic implements WsTopic {

    EXAMPLE_TOPIC("/topic/example-ws");

    private final String topic;

    @Override
    public String toString() {
        return topic;
    }
}
