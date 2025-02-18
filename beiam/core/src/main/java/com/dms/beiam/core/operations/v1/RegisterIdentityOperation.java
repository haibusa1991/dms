package com.dms.beiam.core.operations.v1;

import com.dms.beiam.apiadapter.model.BeiamError;
import com.dms.beiam.apiadapter.operations.v1.register.BeiamRegisterIdentityInput;
import com.dms.beiam.apiadapter.operations.v1.register.BeiamRegisterIdentityResult;
import com.dms.beiam.apiadapter.operations.v1.register.RegisterIdentity;
import com.dms.beiam.core.errorhandler.base.ErrorHandler;
import com.dms.beiam.core.errorhandler.base.ErrorHandlerComponent;
import com.dms.beiam.persistence.entities.Identity;
import com.dms.beiam.persistence.enumeration.IdentityRole;
import com.dms.beiam.persistence.repositories.IdentityRepository;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterIdentityOperation implements RegisterIdentity {
    private final IdentityRepository identityRepository;
    private final PasswordEncoder passwordEncoder;
    private final ErrorHandler errorHandler;


    @Override
    public Either<BeiamError, BeiamRegisterIdentityResult> process(BeiamRegisterIdentityInput input) {
        return Try.of(()-> {
            Identity identity = Identity
                    .builder()
                    .email(input.getEmail())
                    .password(passwordEncoder.encode(input.getPassword()))
                    .identityRole(IdentityRole.READER)
                    .build();

            identityRepository.save(identity);

            return BeiamRegisterIdentityResult
                    .builder()
                    .identityId(identity.getId())
                    .build();
        })
                .toEither()
                .mapLeft(errorHandler::handle);
    }
}
