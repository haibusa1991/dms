package com.dms.beiam.core.commands.v1;

import com.dms.beiam.apiadapter.commands.v1.register.BeiamRegisterIdentityInput;
import com.dms.beiam.apiadapter.commands.v1.register.BeiamRegisterIdentityResult;
import com.dms.beiam.apiadapter.commands.v1.register.RegisterIdentity;
import com.dms.beiam.core.errorhandler.base.ErrorHandler;
import com.dms.beiam.persistence.entities.Identity;
import com.dms.beiam.persistence.enumeration.IdentityRole;
import com.dms.beiam.persistence.repositories.IdentityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterIdentityCommand implements RegisterIdentity {
    private final IdentityRepository identityRepository;
    //    private final PasswordEncoder passwordEncoder;
    private final ErrorHandler errorHandler;


    @Override
    public BeiamRegisterIdentityResult execute(BeiamRegisterIdentityInput input) {
        Identity identity = Identity
                .builder()
                .email(input.getEmail())
//                    .password(passwordEncoder.encode(input.getPassword()))
                .identityRole(IdentityRole.READER)
                .build();

        identityRepository.save(identity);

        return BeiamRegisterIdentityResult
                .builder()
                .identityId(identity.getId())
                .build();
    }
}
