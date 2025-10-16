#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.models.${artifactIdWithoutDash};

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class ExampleResponse {

    @JsonProperty(value = "id", required = true)
    private UUID id;

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "note")
    private String note;

    @Override
    public String toString() {
        return String.format("id: %s, name: %s", id, name);
    }
}