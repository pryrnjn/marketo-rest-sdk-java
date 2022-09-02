package com.smartling.marketo.sdk.domain.leadsdto;

import lombok.Getter;
import lombok.Setter;


@Getter@Setter
public class LeadDetails{
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String postalCode;
    private String createdAt;
    private String updatedAt;
}
