package com.smartling.marketo.sdk.rest;

import com.smartling.marketo.sdk.MarketoApiException;
import com.smartling.marketo.sdk.domain.leadsdto.CreateLeadsRequestDto;
import com.smartling.marketo.sdk.domain.leadsdto.CreateLeadsResponseDto;
import com.smartling.marketo.sdk.rest.command.lead.CreateLeads;

import java.util.List;

public class MarketoLeadClient {

    private final HttpCommandExecutor httpCommandExecutor;

    public MarketoLeadClient(HttpCommandExecutor httpCommandExecutor) {
        this.httpCommandExecutor = httpCommandExecutor;
    }
    public List<CreateLeadsResponseDto> requestCreateLeads(CreateLeadsRequestDto createLeadsRequestDto) throws MarketoApiException {
        return httpCommandExecutor.execute(new CreateLeads(createLeadsRequestDto));
    }
}
