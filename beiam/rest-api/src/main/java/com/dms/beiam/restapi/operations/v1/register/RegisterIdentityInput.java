package com.dms.beiam.restapi.operations.v1.register;

import com.dms.beiam.restapi.base.RestApiInput;
import com.dms.beiam.restapi.validation.password.Password;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class RegisterIdentityInput implements RestApiInput {

    @Email
    private String email;

    @Password
    private String password;
}
