package com.smartling.marketo.sdk.rest.command.programmemberdata;

import com.google.common.collect.ImmutableMap;
import com.smartling.marketo.sdk.domain.programmembers.ProgramMemberField;
import com.smartling.marketo.sdk.domain.programmembers.response.ProgramMemberCreateFieldResult;
import com.smartling.marketo.sdk.rest.command.BaseMarketoCommand;

import java.util.Map;

public class CreateProgramMemberField extends BaseMarketoCommand<ProgramMemberCreateFieldResult> {

    private final ProgramMemberField programMemberField;

    public CreateProgramMemberField(Map<String, String> fields) {
        super(ProgramMemberCreateFieldResult.class);
        this.programMemberField = new ProgramMemberField(fields);
    }

    @Override
    public String getPath() {
        return "/v1/programs/members/schema/fields.json";
    }

    @Override
    public String getMethod() {
        return "POST_BODY";
    }

    @Override
    public Map<String, Object> getParameters() {
        ImmutableMap.Builder<String, Object> builder = ImmutableMap.<String, Object>builder()
                .put("input", new ProgramMemberField[]{this.programMemberField});
        return builder.build();
    }
}
