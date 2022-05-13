package com.smartling.marketo.sdk.rest.command.programmemberdata;

import com.google.common.collect.ImmutableMap;
import com.smartling.marketo.sdk.domain.programmembers.ProgramMemberDataFields;
import com.smartling.marketo.sdk.domain.programmembers.response.ProgramMemberDataResponseDto;
import com.smartling.marketo.sdk.rest.command.BaseMarketoCommand;

import java.util.List;
import java.util.Map;

public class RequestUpdateProgramMemberData extends BaseMarketoCommand<ProgramMemberDataResponseDto> {

    private final Integer programId;
    private final List<ProgramMemberDataFields> programMemberDataFieldsList;

    public RequestUpdateProgramMemberData(Integer programId, List<ProgramMemberDataFields> programMemberDataFieldsList) {
        super(ProgramMemberDataResponseDto.class);
        this.programId = programId;
        this.programMemberDataFieldsList = programMemberDataFieldsList;
    }

    @Override
    public String getPath() {
        return "/rest/v1/programs/"+programId+"/members.json";
    }

    @Override
    public String getMethod() {
        return "POST";
    }

    @Override
    public Map<String, Object> getParameters() {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.<String, Object>builder()
                .put("input", this.programMemberDataFieldsList);
        return builder.build();
    }
}
