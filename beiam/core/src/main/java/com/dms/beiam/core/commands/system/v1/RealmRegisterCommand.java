package com.dms.beiam.core.commands.system.v1;

import com.dms.beiam.apiadapter.commands.system.v1.realm.register.BeiamRealmRegisterInput;
import com.dms.beiam.apiadapter.commands.system.v1.realm.register.BeiamRealmRegisterResult;
import com.dms.beiam.apiadapter.commands.system.v1.realm.register.RealmRegister;
import com.dms.beiam.persistence.entities.Realm;
import com.dms.beiam.persistence.repositories.RealmRepository;
import com.dms.beiam.restapi.errorhandler.exceptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.dms.beiam.restapi.errorhandler.BeaimErrorCodes.REALM_ALREADY_EXISTS;

@Service
@RequiredArgsConstructor
public class RealmRegisterCommand implements RealmRegister {
    private final RealmRepository realmRepository;

    @Override
    public BeiamRealmRegisterResult execute(BeiamRealmRegisterInput input) {

        if (realmRepository.existsByRealmName(input.getRealmName())) {
            throw new BusinessException("Realm with the given name already exists.", HttpStatus.BAD_REQUEST, REALM_ALREADY_EXISTS);
        }

        Realm realm = Realm
                .builder()
                .realmName(input.getRealmName())
                .realmAdminEmail(input.getRealmAdminEmail())
                .build();

        realmRepository.save(realm);

        return BeiamRealmRegisterResult
                .builder()
                .realmId(realm.getId())
                .build();
    }
}
