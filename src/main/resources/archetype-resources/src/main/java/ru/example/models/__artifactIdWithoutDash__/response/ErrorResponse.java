#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.models.${artifactIdWithoutDash}.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class ErrorResponse {

    @JsonProperty(value = "code", required = true)
    private String code;

    @JsonProperty(value = "title", required = true)
    private String title;

    @JsonProperty(value = "description", required = true)
    private String description;
}
