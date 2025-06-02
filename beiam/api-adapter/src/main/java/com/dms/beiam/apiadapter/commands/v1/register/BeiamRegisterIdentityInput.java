package com.dms.beiam.apiadapter.commands.v1.register;

import com.dms.beiam.apiadapter.base.processor.CommandInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class BeiamRegisterIdentityInput implements CommandInput {

    private String email;
    private String password;
}
