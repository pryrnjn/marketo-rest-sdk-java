package com.smartling.marketo.sdk.rest;

import com.smartling.marketo.sdk.MarketoApiException;
import com.smartling.marketo.sdk.domain.programmembers.ProgramMemberDataFields;
import com.smartling.marketo.sdk.domain.programmembers.response.ProgramMemberDataResponseDto;
import com.smartling.marketo.sdk.rest.command.programmemberdata.RequestUpdateProgramMemberData;

import java.util.List;

public class MarketoProgramMemberDataClient {

    private final HttpCommandExecutor httpCommandExecutor;

    public MarketoProgramMemberDataClient(HttpCommandExecutor httpCommandExecutor) {
        this.httpCommandExecutor = httpCommandExecutor;
    }

    public List<ProgramMemberDataResponseDto> requestUpdateProgramMemberData(Integer programId, List<ProgramMemberDataFields> programMemberDataFieldsList) throws MarketoApiException {
       List<ProgramMemberDataResponseDto> programMemberDataResponseDtoList = httpCommandExecutor.execute(new RequestUpdateProgramMemberData(programId,programMemberDataFieldsList));
       return programMemberDataResponseDtoList;
    }
}
