package com.smartling.marketo.sdk.domain.leadsdto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;

@Data
public class CreateAndUpdateLeadsResponseDto {
    private String requestId;
    private boolean success;
    private ArrayList<CreateAndUpdateLeadResult> result;
}
