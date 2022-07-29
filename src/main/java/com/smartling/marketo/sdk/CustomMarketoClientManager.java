package com.smartling.marketo.sdk;

import com.smartling.marketo.sdk.rest.MarketoProgramMemberDataClient;

public interface CustomMarketoClientManager {
    MarketoProgramMemberDataClient getMarketoProgramClient();
}
