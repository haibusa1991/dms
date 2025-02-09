package com.dms.beiam.restapi.operations.v1.register;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class RegisterIdentityInput {

    private String email;
    private String password;
}
