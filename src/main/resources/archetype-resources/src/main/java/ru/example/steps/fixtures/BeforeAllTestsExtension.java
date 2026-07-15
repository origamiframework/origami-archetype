#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ru.example.steps.fixtures;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.concurrent.atomic.AtomicBoolean;

public class BeforeAllTestsExtension implements BeforeAllCallback {

    private static final AtomicBoolean FIRST_EXECUTE = new AtomicBoolean(true);

    @Override
    public void beforeAll(ExtensionContext context) {
        if (FIRST_EXECUTE.getAndSet(false)) {
            // реализация кода, который выполнится один раз перед всеми тестами
        }
    }
}
