package com.smartling.marketo.sdk.domain.programmembers.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ProgramMemberDataResponseDto {

    private String requestId;
    ArrayList<ProgramMemberDataResult> result;
    private boolean success;

}
