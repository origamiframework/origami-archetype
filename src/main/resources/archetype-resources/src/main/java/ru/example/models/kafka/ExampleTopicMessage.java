#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.models.kafka;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder(builderMethodName = "Builder", setterPrefix = "set")
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class ExampleTopicMessage {

    @JsonProperty(value = "id", required = true)
    private UUID id;

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "note")
    private String note;

    @Override
    public String toString() {
        return name;
    }
}
