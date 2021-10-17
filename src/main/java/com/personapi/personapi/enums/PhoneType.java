package com.personapi.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Home"),
    MOBILE("mobile"),
    COMMERCIAL("Commercial");

    private final String description;

}
