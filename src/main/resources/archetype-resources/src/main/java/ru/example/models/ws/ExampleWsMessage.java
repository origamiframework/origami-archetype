#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.models.ws;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class ExampleWsMessage {

    @JsonProperty(value = "id", required = true)
    private String id;

    @JsonProperty(value = "status", required = true)
    private String status;
}
