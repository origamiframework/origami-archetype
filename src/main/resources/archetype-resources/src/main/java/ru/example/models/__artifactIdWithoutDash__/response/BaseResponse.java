#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.models.${artifactIdWithoutDash}.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor(onConstructor = @__(@JsonCreator))
public class BaseResponse<T> {

    @JsonProperty(value = "data", required = true)
    private List<T> data;

    @JsonProperty(value = "errors")
    private List<ErrorResponse> errors;

    @JsonProperty(value = "meta", required = true)
    private MetaResponse meta;

    public static <T> BaseResponse<T> createResponseFrom(Response response, Class<T> clazz) {
        return response.getBody().as(TypeFactory.defaultInstance().constructParametricType(BaseResponse.class, clazz));
    }
}
