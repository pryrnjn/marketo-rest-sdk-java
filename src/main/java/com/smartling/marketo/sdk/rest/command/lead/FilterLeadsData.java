package com.smartling.marketo.sdk.rest.command.lead;

import com.google.common.collect.ImmutableMap;
import com.smartling.marketo.sdk.domain.leadsdto.LeadInfoDto;
import com.smartling.marketo.sdk.rest.command.BaseMarketoCommand;

import java.util.Map;

public class FilterLeadsData extends BaseMarketoCommand<LeadInfoDto> {
    private final String filterType;
    private final String filterValues;

    public FilterLeadsData(String filterType, String filterValues) {
        super(LeadInfoDto.class);
        this.filterType = filterType;
        this.filterValues = filterValues;
    }

    @Override
    public String getPath() {
        return "/v1/leads.json?_method=GET";
    }

    @Override
    public String getMethod() {
        return "POST_BODY";
    }
    @Override
    public Map<String, Object> getParameters() {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        builder.put("filterType",filterType);
        builder.put("filterValues",filterValues);
        return builder.build();
    }
}
