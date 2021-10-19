package com.personapi.personapi.util;

import com.personapi.personapi.dto.request.PhoneDTO;
import com.personapi.personapi.enums.PhoneType;
import com.personapi.personapi.model.Phone;

public class PhoneCreator {

    private static final String PHONE_NUMBER = "(99)999999999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final Long PHONE_ID = 1L;

    public static PhoneDTO createPhoneDTO(){
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
