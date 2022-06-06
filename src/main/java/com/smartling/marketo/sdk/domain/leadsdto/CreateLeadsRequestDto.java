package com.smartling.marketo.sdk.domain.leadsdto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class CreateLeadsRequestDto {
    private String action;
    private String lookupField;
    ArrayList< CreateLeadsBasicInfoRequestDto > input ;
}
