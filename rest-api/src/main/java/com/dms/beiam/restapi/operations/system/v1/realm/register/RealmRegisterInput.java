package com.dms.beiam.restapi.operations.system.v1.realm.register;

import com.dms.beiam.restapi.base.RestApiInput;
import com.dms.beiam.restapi.validation.password.Password;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class RealmRegisterInput implements RestApiInput {

    @NotBlank
    private String realmName;

    @Email
    @NotNull
    private String realmAdminEmail;
}
