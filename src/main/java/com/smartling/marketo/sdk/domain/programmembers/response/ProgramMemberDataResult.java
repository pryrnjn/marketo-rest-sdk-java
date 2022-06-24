package com.smartling.marketo.sdk.domain.programmembers.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgramMemberDataResult {

    private float seq;
    private String status;
    ArrayList<SkipReason> reasons;
    private Integer leadId;

}
