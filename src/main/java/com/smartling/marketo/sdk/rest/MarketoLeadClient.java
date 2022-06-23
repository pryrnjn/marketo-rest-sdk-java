package com.smartling.marketo.sdk.rest;

import com.smartling.marketo.sdk.MarketoApiException;
import com.smartling.marketo.sdk.domain.leadsdto.CreateAndUpdateLeadsRequestDto;
import com.smartling.marketo.sdk.domain.leadsdto.CreateAndUpdateLeadsResponseDto;
import com.smartling.marketo.sdk.domain.leadsdto.LeadInfoDto;
import com.smartling.marketo.sdk.rest.command.lead.CreateAndUpdateLeads;
import com.smartling.marketo.sdk.rest.command.lead.FilterLeadsData;

import java.util.List;

public class MarketoLeadClient {

    private final HttpCommandExecutor httpCommandExecutor;

    public MarketoLeadClient(HttpCommandExecutor httpCommandExecutor) {
        this.httpCommandExecutor = httpCommandExecutor;
    }
    public CreateAndUpdateLeadsResponseDto requestCreateLeads(
            CreateAndUpdateLeadsRequestDto createLeadsRequestDto) throws MarketoApiException {
        List<CreateAndUpdateLeadsResponseDto> createLeadsResponseDtoList=httpCommandExecutor.execute(new CreateAndUpdateLeads(createLeadsRequestDto));
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
