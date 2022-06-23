package com.smartling.marketo.sdk.domain.leadsdto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CreateLeadResult {
    private Integer id;
    /***
     * made status ignorable because it's no used anymore
     */
    @JsonIgnore
    private String status;
}
