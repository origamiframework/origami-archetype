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
public class MetaResponse {

    @JsonProperty(value = "total", required = true)
    private Integer total;
}
