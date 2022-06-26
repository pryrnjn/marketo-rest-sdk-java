package com.smartling.marketo.sdk.domain.programmembers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter @Setter @ToString @AllArgsConstructor
public class ProgramMemberField {
    private String displayName;
    private String name;
    private String description;
    private String dataType;

    public ProgramMemberField(Map<String, String> fieldDetailsMap) {
        this(fieldDetailsMap.get("displayName"), fieldDetailsMap.get("name"), fieldDetailsMap.get("description"), fieldDetailsMap.get("dataType"));
    }
}
