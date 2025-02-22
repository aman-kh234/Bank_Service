package com.bank.modal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeOfCreditDto {
    HOME_LOAN("HOME_LOAN"),
    CAR_LOAN("CAR_LOAN"),
    PERSONAL_LOAN("PERSONAL_LOAN"),
    CREDIT_CARD("CREDIT_CARD");

    private final String value;

    TypeOfCreditDto(String value) {
        this.value = value;
    }

    @JsonValue  // Ensures the value is serialized as a string
    public String getValue() {
        return value;
    }

    @JsonCreator  // Allows Jackson to map a String to the enum
    public static TypeOfCreditDto fromValue(String value) {
        for (TypeOfCreditDto type : TypeOfCreditDto.values()) {
            if (type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown credit type: " + value);
    }
}
