package com.smartling.marketo.sdk.rest;

import com.smartling.marketo.sdk.MarketoApiException;
import com.smartling.marketo.sdk.domain.leadsdto.CreateAndUpdateLeadResult;
import com.smartling.marketo.sdk.domain.leadsdto.CreateAndUpdateLeadsRequestDto;
import com.smartling.marketo.sdk.domain.leadsdto.LeadDetails;
import com.smartling.marketo.sdk.rest.command.lead.CreateAndUpdateLeads;
import com.smartling.marketo.sdk.rest.command.lead.FilterLeadsData;

import java.util.List;

public class MarketoLeadClient {

    private final HttpCommandExecutor httpCommandExecutor;

    public MarketoLeadClient(HttpCommandExecutor httpCommandExecutor) {
        this.httpCommandExecutor = httpCommandExecutor;
    }
    public List<CreateAndUpdateLeadResult> requestCreateLeads(
            CreateAndUpdateLeadsRequestDto createLeadsRequestDto) throws MarketoApiException {
        return httpCommandExecutor.execute(new CreateAndUpdateLeads(createLeadsRequestDto));
    }

    public List<LeadDetails> findLeadsByFilterType(String filterType,String filterValues) throws MarketoApiException {
       return httpCommandExecutor.execute(new FilterLeadsData(filterType,filterValues));
    }

}
