#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.steps.${artifactIdWithoutDash};

import ru.origami.common.environment.Environment;
import ru.origami.rest.models.RequestSpec;
import ru.example.steps.CommonSteps;

public class CommonExampleRequestsSteps extends CommonSteps {

    protected RequestSpec getExampleRequestSpec(String token) {
        return getExampleServiceSpecBuilder()
                .setBasePath(Environment.get("example.service.example.relative.uri"))
                .setContentType("application/json")
                .addNotNullHeader("Authorization", token)
                .build();
    }
}