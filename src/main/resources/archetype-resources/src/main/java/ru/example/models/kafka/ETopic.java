#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.models.kafka;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.origami.kafka.models.Topic;

@Getter
@AllArgsConstructor
public enum ETopic implements Topic {

    EXAMPLE_TOPIC("example-topic");

    private final String topic;

    @Override
    public String toString() {
        return topic;
    }
}
