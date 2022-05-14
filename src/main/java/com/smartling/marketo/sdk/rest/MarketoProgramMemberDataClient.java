package com.smartling.marketo.sdk.rest;

import com.smartling.marketo.sdk.MarketoApiException;
import com.smartling.marketo.sdk.domain.programmembers.ProgramMemberDataFields;
import com.smartling.marketo.sdk.domain.programmembers.response.ProgramMemberCreateFieldResult;
import com.smartling.marketo.sdk.domain.programmembers.response.ProgramMemberDataResponseDto;
import com.smartling.marketo.sdk.rest.command.programmemberdata.CreateProgramMemberField;
import com.smartling.marketo.sdk.rest.command.programmemberdata.RequestUpdateProgramMemberData;

import java.util.List;
import java.util.Map;

public class MarketoProgramMemberDataClient {

    private final HttpCommandExecutor httpCommandExecutor;

    public MarketoProgramMemberDataClient(HttpCommandExecutor httpCommandExecutor) {
        this.httpCommandExecutor = httpCommandExecutor;
    }

    public List<ProgramMemberDataResponseDto> requestUpdateProgramMemberData(Integer programId, List<ProgramMemberDataFields> programMemberDataFieldsList) throws MarketoApiException {
        return httpCommandExecutor.execute(new RequestUpdateProgramMemberData(programId,programMemberDataFieldsList));
    }

    public List<ProgramMemberCreateFieldResult> createProgramMemberField(Map<String, String> fields) throws MarketoApiException {
        return httpCommandExecutor.execute(new CreateProgramMemberField(fields));
    }
}
