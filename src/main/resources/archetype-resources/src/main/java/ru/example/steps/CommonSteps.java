#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.steps;

import io.restassured.RestAssured;
import ru.origami.common.environment.Environment;
import ru.origami.rest.RestSteps;
import ru.origami.rest.models.RequestSpecBuilder;

public class CommonSteps extends RestSteps {

    public CommonSteps() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    protected RequestSpecBuilder getExampleServiceSpecBuilder() {
        return getRequestSpecBuilder()
                .setBaseUri(Environment.get("example.service.url"))
                .setNotNullPort(Environment.getIntWithNullValue("example.service.port"))
                .addHeader("Accept", "application/json");
    }
}