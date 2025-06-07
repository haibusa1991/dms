package com.dms.beiam.persistence.repositories;

import com.dms.beiam.persistence.entities.Identity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IdentityRepository extends JpaRepository<Identity, UUID> {
}
