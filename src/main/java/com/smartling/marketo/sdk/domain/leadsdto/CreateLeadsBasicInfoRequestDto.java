package com.smartling.marketo.sdk.domain.leadsdto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLeadsBasicInfoRequestDto {
    private String email;
    private String firstName;
    private String postalCode;
}
