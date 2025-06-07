package com.dms.beiam.persistence.repositories;

import com.dms.beiam.persistence.entities.Realm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RealmRepository extends JpaRepository<Realm, UUID> {

    Boolean existsByRealmName(String realmName);
}
