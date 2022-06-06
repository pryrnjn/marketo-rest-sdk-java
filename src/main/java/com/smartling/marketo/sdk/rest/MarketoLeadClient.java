package com.smartling.marketo.sdk.rest;

import com.smartling.marketo.sdk.MarketoApiException;
import com.smartling.marketo.sdk.domain.leadsdto.CreateLeadsRequestDto;
import com.smartling.marketo.sdk.domain.leadsdto.CreateLeadsResponseDto;
import com.smartling.marketo.sdk.domain.leadsdto.LeadInfoDto;
import com.smartling.marketo.sdk.rest.command.lead.CreateLeads;
import com.smartling.marketo.sdk.rest.command.lead.FilterLeadsData;

import java.util.List;

public class MarketoLeadClient {

    private final HttpCommandExecutor httpCommandExecutor;

    public MarketoLeadClient(HttpCommandExecutor httpCommandExecutor) {
        this.httpCommandExecutor = httpCommandExecutor;
    }
    public CreateLeadsResponseDto requestCreateLeads(CreateLeadsRequestDto createLeadsRequestDto) throws MarketoApiException {
        List<CreateLeadsResponseDto> createLeadsResponseDtoList=httpCommandExecutor.execute(new CreateLeads(createLeadsRequestDto));
        if(createLeadsResponseDtoList.isEmpty())
            return null;
        return createLeadsResponseDtoList.get(0);
    }

    public LeadInfoDto findLeadsByFilterType(String filterType,String filterValues) throws MarketoApiException {
       List<LeadInfoDto> leadInfoDtos= httpCommandExecutor.execute(new FilterLeadsData(filterType,filterValues));
       if(leadInfoDtos.isEmpty())
           return null;
       return leadInfoDtos.get(0);
    }

}
