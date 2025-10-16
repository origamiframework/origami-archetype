#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.models.ibm_mq;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.origami.ibm_mq.models.Queue;

@Getter
@AllArgsConstructor
public enum EQueue implements Queue {

    EXAMPLE_QUEUE("example-queue");

    private final String queue;

    @Override
    public String toString() {
        return queue;
    }
}
