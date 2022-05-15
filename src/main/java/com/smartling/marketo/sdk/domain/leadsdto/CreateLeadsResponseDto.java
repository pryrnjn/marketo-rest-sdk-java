package com.smartling.marketo.sdk.domain.leadsdto;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Getter@Setter
public class CreateLeadsResponseDto {
    private String requestId;
    private boolean success;
    private ArrayList< CreateLeadResult > result;
}
