package com.smartling.marketo.sdk.rest.command.customobject;

import com.google.common.collect.ImmutableMap;
import com.smartling.marketo.sdk.domain.customobject.CustomObjectFieldValues;
import com.smartling.marketo.sdk.domain.customobject.response.CustomObjectCreateAndUpdateResult;
import com.smartling.marketo.sdk.rest.command.BaseMarketoCommand;

import java.util.List;
import java.util.Map;

public class RequestCreateAndUpdateCustomObject
        extends BaseMarketoCommand<CustomObjectCreateAndUpdateResult> {

    private final String customObjectName;
    private final String dedupeBy;
    private final ActionType action;
    private final List<CustomObjectFieldValues> customObjectFieldValuesList;

    public RequestCreateAndUpdateCustomObject(String customObjectName,
            ActionType actionType,
            List<CustomObjectFieldValues> customObjectFieldValuesList) {
        super(CustomObjectCreateAndUpdateResult.class);
        this.customObjectName = customObjectName;
        this.action = actionType;
        this.dedupeBy = "dedupeFields";
        this.customObjectFieldValuesList = customObjectFieldValuesList;
    }

    public enum ActionType {
        createOrUpdate, createOnly, updateOnly, createDuplicate;
    }

    @Override
    public String getPath() {
        return "/v1/customobjects/" + customObjectName + ".json";
    }

    @Override
    public String getMethod() {
        return "POST_BODY";
    }

    @Override
    public Map<String, Object> getParameters() {
        ImmutableMap.Builder<String, Object> builder =
                ImmutableMap.<String, Object>builder()
                        .put("action", this.action)
                        .put("dedupeBy", this.dedupeBy)
                        .put("input", this.customObjectFieldValuesList);
        return builder.build();
    }
}
