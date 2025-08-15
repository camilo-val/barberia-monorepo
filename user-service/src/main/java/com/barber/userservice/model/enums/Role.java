package com.barber.userservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Role {
    admin("admin"),
    client("client"),
    employed("employed");
    private final String role;
}
