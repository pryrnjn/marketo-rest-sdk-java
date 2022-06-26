package com.smartling.marketo.sdk.domain.leadsdto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Builder
public class CreateAndUpdateLeadsRequestDto {

    private ActionType action;
    private String lookupField;
    ArrayList<CreateAndUpdateLeadsModel> input;

    public enum ActionType {
        createOrUpdate, createOnly, updateOnly, createDuplicate;
    }
}
