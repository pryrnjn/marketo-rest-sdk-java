package com.smartling.marketo.sdk.rest;

import com.smartling.marketo.sdk.MarketoApiException;

import java.util.Objects;

final class CustomRetryingHttpCommandExecutor implements HttpCommandExecutor{
    private final HttpCommandExecutor executor;
    private final RetryPolicy retryPolicy;

    CustomRetryingHttpCommandExecutor(HttpCommandExecutor executor, RetryPolicy retryPolicy) {
        this.executor = Objects.requireNonNull(executor, "Executor should not be null");
        this.retryPolicy = Objects.requireNonNull(retryPolicy, "Retry policy should not be null");
    }

    @Override
    public <T> T execute(Command<T> command) throws MarketoApiException {
        RetryPolicy.Execution execution = retryPolicy.newExecution();

        while (true) {
            try {
                return executor.execute(command);
            } catch (MarketoApiException e) {
                execution.waitOrRethrow(e);
            }
        }
    }
}
