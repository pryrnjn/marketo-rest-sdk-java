package com.smartling.marketo.sdk.domain.programmembers;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgramMemberDataFields {
    private Integer leadId;
    private String registrationCode;
    private String webinarUrl;
    private String myCustomField;
}
