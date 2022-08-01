package com.smartling.marketo.sdk.rest.command.lead;

import com.google.common.collect.ImmutableMap;
import com.smartling.marketo.sdk.domain.leadsdto.LeadDetails;
import com.smartling.marketo.sdk.rest.command.BaseMarketoCommand;

import java.util.Map;

public class FilterLeadsData extends BaseMarketoCommand<LeadDetails> {
    private final String filterType;
    private final String filterValues;

    public FilterLeadsData(String filterType, String filterValues) {
        super(LeadDetails.class);
        this.filterType = filterType;
        this.filterValues = filterValues;
    }

    @Override
    public String getPath() {
        return "/v1/leads.json";
    }

    @Override
    public String getMethod() {
        return "GET";
    }
    @Override
    public Map<String, Object> getParameters() {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        builder.put("filterType",filterType);
        builder.put("filterValues",filterValues);
        return builder.build();
    }
}
