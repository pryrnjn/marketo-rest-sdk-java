package com.smartling.marketo.sdk.rest.command.lead;

import com.google.common.collect.ImmutableMap;
import com.smartling.marketo.sdk.domain.leadsdto.CreateAndUpdateLeadsRequestDto;
import com.smartling.marketo.sdk.domain.leadsdto.CreateAndUpdateLeadsResponseDto;
import com.smartling.marketo.sdk.rest.command.BaseMarketoCommand;
import java.util.Map;

public class CreateAndUpdateLeads extends BaseMarketoCommand<CreateAndUpdateLeadsResponseDto> {

    private CreateAndUpdateLeadsRequestDto createLeadRequestDto;

    public CreateAndUpdateLeads(CreateAndUpdateLeadsRequestDto createLeadRequestDto){
        super(CreateAndUpdateLeadsResponseDto.class);
        this.createLeadRequestDto=createLeadRequestDto;
    }

    protected CreateAndUpdateLeads(Class<CreateAndUpdateLeadsResponseDto> type) {
        super(type);
    }

    @Override
    public String getPath() {
        return "/v1/leads.json";
    }

    @Override
    public String getMethod() {
        return "POST_BODY";
    }

    @Override
    public Map<String, Object> getParameters() {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.builder();
        if(null != createLeadRequestDto.getAction())
            builder.put("action",createLeadRequestDto.getAction());
        if(null != createLeadRequestDto.getLookupField())
            builder.put("lookupField",createLeadRequestDto.getLookupField());
        builder.put("input",createLeadRequestDto.getInput());
        return builder.build();
    }
}
