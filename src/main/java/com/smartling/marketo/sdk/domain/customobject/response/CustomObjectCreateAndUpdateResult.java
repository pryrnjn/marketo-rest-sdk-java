package com.smartling.marketo.sdk.domain.customobject.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomObjectCreateAndUpdateResult {

    private Integer seq;
    private String status;
    private String marketoGUID;
    ArrayList<SkipReason> reasons;

    @Data
    public static class SkipReason {
        private String code;
        private String message;
    }
}
