package com.smartling.marketo.sdk.rest;

import com.google.common.base.Preconditions;
import com.smartling.marketo.sdk.CustomMarketoClientManager;
import com.smartling.marketo.sdk.rest.transport.*;
import com.smartling.marketo.sdk.rest.transport.logging.JsonClientLoggingFilter;

public class CustomMarketoRestClientManager  implements CustomMarketoClientManager {
    private static final TokenProvider tokenProvider = new CacheableTokenProvider(new BasicTokenProvider());

    private final HttpCommandExecutor httpCommandExecutor;

    private CustomMarketoRestClientManager(HttpCommandExecutor httpCommandExecutor) {
        this.httpCommandExecutor = httpCommandExecutor;
    }

    public static Builder create(String identityUrl, String restUrl) {
        Preconditions.checkNotNull(identityUrl, "Identity URL is empty");
        Preconditions.checkNotNull(restUrl, "REST endpoint URL is empty");

        return new Builder(identityUrl, restUrl);
    }

    @Override
    public MarketoProgramMemberDataClient getMarketoProgramClient() {
        return new MarketoProgramMemberDataClient(httpCommandExecutor);
    }

    public final static class Builder {
        private final String identityUrl;
        private final String restUrl;
        private int connectionTimeout;
        private int socketReadTimeout;
        private RetryPolicy retryPolicy = RetryPolicy.NONE;
        private JsonClientLoggingFilter loggingFilter;

        private Builder(String identityUrl, String restUrl) {
            this.identityUrl = identityUrl;
            this.restUrl = restUrl;
        }

        public CustomMarketoRestClientManager.Builder withLoggingFilter(JsonClientLoggingFilter loggingFilter) {
            this.loggingFilter = loggingFilter;
            return this;
        }

        public CustomMarketoRestClientManager withCredentials(String clientId, String clientSecret) {
            Preconditions.checkNotNull(clientId, "Client ID is empty");
            Preconditions.checkNotNull(clientSecret, "Client secret is empty");

            CustomJaxRsHttpCommandExecutor executor = new CustomJaxRsHttpCommandExecutor(identityUrl, restUrl, clientId, clientSecret, tokenProvider, loggingFilter);
            executor.setConnectionTimeout(connectionTimeout);
            executor.setSocketReadTimeout(socketReadTimeout);
            return new CustomMarketoRestClientManager(new CustomRetryingHttpCommandExecutor(executor, retryPolicy));
        }

        public CustomMarketoRestClientManager.Builder withConnectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public CustomMarketoRestClientManager.Builder withSocketReadTimeout(int socketReadTimeout) {
            this.socketReadTimeout = socketReadTimeout;
            return this;
        }

        public CustomMarketoRestClientManager.Builder withRetryPolicy(RetryPolicy retryPolicy) {
            this.retryPolicy = Preconditions.checkNotNull(retryPolicy, "Retry Policy can not be null");
            return this;
        }
    }
}
